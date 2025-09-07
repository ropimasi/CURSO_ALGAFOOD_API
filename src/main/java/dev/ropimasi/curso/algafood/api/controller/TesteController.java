package dev.ropimasi.curso.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.ropimasi.curso.algafood.domain.model.Cozinha;
import dev.ropimasi.curso.algafood.domain.model.Restaurante;
import dev.ropimasi.curso.algafood.domain.repository.CozinhaRepository;
import dev.ropimasi.curso.algafood.domain.repository.RestauranteRepository;




@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;



	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPornome(@RequestParam("nome") String nome) {
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}



	@GetMapping("/cozinhas/unica-por-nome")
	public Optional<Cozinha> cozinhaUnicaPorNome(@RequestParam("nome") String nome) {
		return cozinhaRepository.findUnicaByNome(nome);
	}



	@GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantePorTaxaFrete(@RequestParam("taxaFreteInicial") BigDecimal taxaFreteInicial,
			@RequestParam("taxaFreteFinal") BigDecimal taxaFreteFinal) {
		return restauranteRepository.findByTaxaFreteBetween(taxaFreteInicial, taxaFreteFinal);
	}



	@GetMapping("/restaurantes/por-nome-cozinhaid")
	public List<Restaurante> restaurantePorNomeCozinhaId(@RequestParam("nome") String nome,
			@RequestParam("cozinhaId") Long cozinhaId) {
		return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
	}

}
