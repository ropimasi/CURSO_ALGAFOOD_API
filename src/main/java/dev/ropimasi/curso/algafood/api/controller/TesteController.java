package dev.ropimasi.curso.algafood.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.ropimasi.curso.algafood.domain.model.Cozinha;
import dev.ropimasi.curso.algafood.domain.repository.CozinhaRepository;




@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;



	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPornome(@RequestParam("nome") String nome) {
		return cozinhaRepository.ListarPorNome(nome);
	}

}
