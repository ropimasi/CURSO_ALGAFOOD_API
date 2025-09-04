package dev.ropimasi.curso.algafood.infrastructure.repository;

import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import dev.ropimasi.curso.algafood.domain.model.Estado;
import dev.ropimasi.curso.algafood.domain.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;




@Component
public class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager manager;



	@Override
	public List<Estado> listar() {
		TypedQuery<Estado> query = manager.createQuery("from Estado", Estado.class);
		return query.getResultList();
	}



	@Override
	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}



	@Override
	@Transactional
	public Estado salvar(Estado estado) {
		return manager.merge(estado);
	}



	@Override
	@Transactional
	public void remover(Long id) {
		Estado estado = buscar(id);

		if (estado == null) {
			throw new EmptyResultDataAccessException(1);
		}

		manager.remove(estado);
	}
}
