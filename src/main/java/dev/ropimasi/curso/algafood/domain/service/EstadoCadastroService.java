package dev.ropimasi.curso.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import dev.ropimasi.curso.algafood.domain.exception.EntidadeEmUsoException;
import dev.ropimasi.curso.algafood.domain.exception.EntidadeNaoEncontradaException;
import dev.ropimasi.curso.algafood.domain.model.Estado;
import dev.ropimasi.curso.algafood.domain.repository.EstadoRepository;




@Service
public class EstadoCadastroService {

	@Autowired
	private EstadoRepository estadoRepository;



	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}



	public void excluir(Long id) {
		try {
			estadoRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Estado de código %d não existe para ser removido.", id));
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado de código %d não pode ser removido, pois está em uso.", id));
		}

	}
}
