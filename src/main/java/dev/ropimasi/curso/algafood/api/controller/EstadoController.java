package dev.ropimasi.curso.algafood.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.ropimasi.curso.algafood.domain.exception.EntidadeEmUsoException;
import dev.ropimasi.curso.algafood.domain.exception.EntidadeNaoEncontradaException;
import dev.ropimasi.curso.algafood.domain.model.Estado;
import dev.ropimasi.curso.algafood.domain.repository.EstadoRepository;
import dev.ropimasi.curso.algafood.domain.service.EstadoCadastroService;




@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private EstadoCadastroService estadoCadastroService;



	@GetMapping
	public List<Estado> listar() {
		return estadoRepository.listar();
	}



	@GetMapping("/{estadoId}")
	public ResponseEntity<Estado> buscar(@PathVariable Long estadoId) {
		Estado estado = estadoRepository.buscar(estadoId);

		if (estado != null) {
			return ResponseEntity.ok(estado);
		}

		return ResponseEntity.notFound().build();
	}



	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED) // alternativo.
	public ResponseEntity<Estado> adicionar(@RequestBody Estado estado) {
		estado = estadoCadastroService.salvar(estado);
		return ResponseEntity.status(HttpStatus.CREATED).body(estado);
	}



	@PutMapping("/{estadoId}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId, @RequestBody Estado estado) {
		Estado estadoPersistido = estadoRepository.buscar(estadoId);

		if (estadoPersistido != null) {
			estado.setId(estadoId);
			estado = estadoCadastroService.salvar(estado);
			return ResponseEntity.ok(estado);
		}

		return ResponseEntity.notFound().build();
	}



	@DeleteMapping(value = "/{estadoId}")
	public ResponseEntity<?> remover(@PathVariable Long estadoId) {
		try {
			estadoCadastroService.excluir(estadoId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

}
