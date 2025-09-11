package dev.ropimasi.curso.algafood.api.controller;

import static dev.ropimasi.curso.algafood.infrastructure.repository.spec.RestauranteSpecs.comFreteGratis;
import static dev.ropimasi.curso.algafood.infrastructure.repository.spec.RestauranteSpecs.comNomeSemelhante;
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

// teste renaming repo.




@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;



	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome) {
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}



	@GetMapping("/cozinhas/unica-por-nome")
	public Optional<Cozinha> cozinhaUnicaPorNome(@RequestParam("nome") String nome) {
		return cozinhaRepository.findUnicaByNome(nome);
	}



	@GetMapping("/cozinhas/exists")
	public boolean cozinhaExists(String nome) {
		return cozinhaRepository.existsByNome(nome);
	}



	@GetMapping("/restaurantes/por-nome")
	public List<Restaurante> restaurantesPorNome(String nome) {
		return restauranteRepository.findByNomeContaining(nome);
	}



	@GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantePorTaxaFrete(@RequestParam("taxaFreteInicial") BigDecimal taxaFreteInicial,
			@RequestParam("taxaFreteFinal") BigDecimal taxaFreteFinal) {
		return restauranteRepository.queryByTaxaFreteBetween(taxaFreteInicial, taxaFreteFinal);
	}



	@GetMapping("/restaurantes/por-nome-cozinhaid")
	public List<Restaurante> restaurantePorNomeCozinhaId(@RequestParam("nome") String nome,
			@RequestParam("cozinhaId") Long cozinhaId) {
		//		return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
		return restauranteRepository.porNomeCozinhaId(nome, cozinhaId);
	}



	@GetMapping("/restaurantes/count-por-cozinha")
	public int restauranteCountPorCozinha(@RequestParam("cozinhaId") Long cozinhaId) {
		return restauranteRepository.countByCozinhaId(cozinhaId);
	}



	@GetMapping("/restaurantes/primeiro-por-nome")
	public Optional<Restaurante> restaurantePrimeiroPorNome(@RequestParam("nome") String nome) {
		return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
	}



	@GetMapping("/restaurantes/top2-por-nome")
	public List<Restaurante> restauranteTop2PorNome(String nome) {
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}



	@GetMapping("/restaurantes/por-nome-taxa-frete-entre")
	public List<Restaurante> restaurantePorNomeTaxaFreteEntre(String nome, BigDecimal taxaFreteInicial,
			BigDecimal taxaFreteFinal) {
		return restauranteRepository.porNomeTaxaFreteEntre(nome, taxaFreteInicial, taxaFreteFinal);
	}



	@GetMapping("/restaurantes/consulta")
	public List<Restaurante> restaurantesConsulta(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		return restauranteRepository.consulta(nome, taxaFreteInicial, taxaFreteFinal);
	}



	@GetMapping("/restaurantes/por-nome-com-frete-gratis")
	public List<Restaurante> restaurantesPorNomeComFreteGratis(String nome) {

		return restauranteRepository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
	}

}
