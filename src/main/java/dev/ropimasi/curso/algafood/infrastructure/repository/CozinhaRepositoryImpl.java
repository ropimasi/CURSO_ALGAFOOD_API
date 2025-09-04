package dev.ropimasi.curso.algafood.infrastructure.repository;

import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import dev.ropimasi.curso.algafood.domain.model.Cozinha;
import dev.ropimasi.curso.algafood.domain.repository.CozinhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;




@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

	@PersistenceContext
	private EntityManager manager;



	@Override
	public List<Cozinha> listar() {
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		return query.getResultList();
	}



	@Override
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}



	@Override
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}



	@Override
	@Transactional
	public void remover(Long id) {
		Cozinha cozinha = buscar(id);

		if (cozinha == null) {
			throw new EmptyResultDataAccessException(1);
		}

		manager.remove(cozinha);
	}
}
