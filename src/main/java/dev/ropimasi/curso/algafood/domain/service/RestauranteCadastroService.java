package dev.ropimasi.curso.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import dev.ropimasi.curso.algafood.domain.exception.EntidadeNaoEncontradaException;
import dev.ropimasi.curso.algafood.domain.model.Cozinha;
import dev.ropimasi.curso.algafood.domain.model.Restaurante;
import dev.ropimasi.curso.algafood.domain.repository.CozinhaRepository;
import dev.ropimasi.curso.algafood.domain.repository.RestauranteRepository;




@Service
public class RestauranteCadastroService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;



	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com código %d", cozinhaId)));

		//		Alternativa do professor:
		//		if (cozinhaOpt.isEmpty()) {
		//			throw new EntidadeNaoEncontradaException(
		//					String.format("Não existe cadastro de cozinha com código %d", cozinhaId));
		//		}

		restaurante.setCozinha(cozinha);
		return restauranteRepository.save(restaurante);
	}



	public void excluir(Long id) {
		try {
			restauranteRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Restaurante de código %d não existe para ser removido.", id));
		}
	}

}
