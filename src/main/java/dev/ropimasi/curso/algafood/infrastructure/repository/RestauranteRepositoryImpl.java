package dev.ropimasi.curso.algafood.infrastructure.repository;

import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import dev.ropimasi.curso.algafood.domain.model.Restaurante;
import dev.ropimasi.curso.algafood.domain.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;




@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

	@PersistenceContext
	private EntityManager manager;



	@Override
	public List<Restaurante> listar() {
		TypedQuery<Restaurante> query = manager.createQuery("from Restaurante", Restaurante.class);
		return query.getResultList();
	}



	@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}



	@Override
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}



	@Override
	@Transactional
	public void remover(Long id) {
		Restaurante restaurante = buscar(id);

		if (restaurante == null) {
			throw new EmptyResultDataAccessException(1);
		}

		manager.remove(restaurante);
	}
}
