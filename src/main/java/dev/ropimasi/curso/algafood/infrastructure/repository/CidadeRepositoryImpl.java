package dev.ropimasi.curso.algafood.infrastructure.repository;

import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import dev.ropimasi.curso.algafood.domain.model.Cidade;
import dev.ropimasi.curso.algafood.domain.repository.CidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;




@Component
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager manager;



	@Override
	public List<Cidade> listar() {
		TypedQuery<Cidade> query = manager.createQuery("from Cidade", Cidade.class);
		return query.getResultList();
	}



	@Override
	public Cidade buscar(Long id) {
		return manager.find(Cidade.class, id);
	}



	@Override
	@Transactional
	public Cidade salvar(Cidade cidade) {
		return manager.merge(cidade);
	}



	@Override
	@Transactional
	public void remover(Long id) {
		Cidade cidade = buscar(id);

		if (cidade == null) {
			throw new EmptyResultDataAccessException(1);
		}

		manager.remove(cidade);
	}
}
