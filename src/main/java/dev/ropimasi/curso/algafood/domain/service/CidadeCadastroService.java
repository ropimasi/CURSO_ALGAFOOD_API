package dev.ropimasi.curso.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import dev.ropimasi.curso.algafood.domain.exception.EntidadeEmUsoException;
import dev.ropimasi.curso.algafood.domain.exception.EntidadeNaoEncontradaException;
import dev.ropimasi.curso.algafood.domain.model.Cidade;
import dev.ropimasi.curso.algafood.domain.model.Estado;
import dev.ropimasi.curso.algafood.domain.repository.CidadeRepository;
import dev.ropimasi.curso.algafood.domain.repository.EstadoRepository;




@Service
public class CidadeCadastroService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;



	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();

		Estado estado = estadoRepository.findById(estadoId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("Não existe cadastro de Estado com código %d", estadoId)));

		cidade.setEstado(estado);
		return cidadeRepository.save(cidade);
	}



	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Cidade de código %d não existe para ser removido.", cidadeId));
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
                    String.format("Cidade de código %d não pode ser removido, pois está em uso.", cidadeId));
		}
	}

}
