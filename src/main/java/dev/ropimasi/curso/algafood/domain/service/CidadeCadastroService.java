package dev.ropimasi.curso.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
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
		Estado estado = estadoRepository.buscar(estadoId);

		if (estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de Estado com código %d", estadoId));
		}

		cidade.setEstado(estado);
		return cidadeRepository.salvar(cidade);
	}



	public void excluir(Long id) {
		try {
			cidadeRepository.remover(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Cidade de código %d não existe para ser removido.", id));
		}
	}

}
