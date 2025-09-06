package dev.ropimasi.curso.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import dev.ropimasi.curso.algafood.domain.exception.EntidadeEmUsoException;
import dev.ropimasi.curso.algafood.domain.exception.EntidadeNaoEncontradaException;
import dev.ropimasi.curso.algafood.domain.model.Cozinha;
import dev.ropimasi.curso.algafood.domain.repository.CozinhaRepository;




@Service
public class CozinhaCadastroService {

	@Autowired
	private CozinhaRepository cozinhaRepository;



	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}



	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.deleteById(cozinhaId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Cozinha de código %d não existe para ser removida.", cozinhaId));
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de código %d não pode ser removida, pois está em uso.", cozinhaId));
		}

	}
}
