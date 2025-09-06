package dev.ropimasi.curso.algafood.api.controller;

import java.util.List;
import java.util.Optional;
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
import dev.ropimasi.curso.algafood.domain.model.Cidade;
import dev.ropimasi.curso.algafood.domain.repository.CidadeRepository;
import dev.ropimasi.curso.algafood.domain.service.CidadeCadastroService;




@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CidadeCadastroService cidadeCadastroService;



	@GetMapping
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}



	@GetMapping(value = "{cidadeId}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
		Optional<Cidade> cidadeOpt = cidadeRepository.findById(cidadeId);
		
		if (cidadeOpt.isPresent()) {
			return ResponseEntity.ok(cidadeOpt.get());
		}

		return ResponseEntity.notFound().build();
	}



	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED) // alternativo.
	public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
		try {
			cidade = cidadeCadastroService.salvar(cidade);
			return ResponseEntity.status(HttpStatus.CREATED).body(cidade);

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}



	@PutMapping(value = "/{cidadeId}")
	public ResponseEntity<?> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
	Optional<Cidade> cidadePersistidaOpt = cidadeRepository.findById(cidadeId);

		if (cidadePersistidaOpt.isPresent()) {
			cidade.setId(cidadeId);
			try {
				cidade = cidadeCadastroService.salvar(cidade);
				return ResponseEntity.status(HttpStatus.OK).body(cidade);

			} catch (EntidadeNaoEncontradaException e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			}
		}
		return ResponseEntity.notFound().build();
	}



	@DeleteMapping(value = "/{cidadeId}")
	public ResponseEntity<?> remover(@PathVariable Long cidadeId) {
		try {
			cidadeCadastroService.excluir(cidadeId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

}
