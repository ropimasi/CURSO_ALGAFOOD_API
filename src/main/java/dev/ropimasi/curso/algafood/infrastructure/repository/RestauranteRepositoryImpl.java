package dev.ropimasi.curso.algafood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Repository;
import dev.ropimasi.curso.algafood.domain.model.Restaurante;
import dev.ropimasi.curso.algafood.domain.repository.RestauranteRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;




@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryCustom { // SDJ implementação customizada.

	@PersistenceContext
	private EntityManager em;



	@Override
	public List<Restaurante> porNomeTaxaFreteEntre(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		var jpql = "from Restaurante where nome like :nome "
				+ "and taxaFrete between :taxaInicial and :taxaFinal";
		
		return em.createQuery(jpql, Restaurante.class)
				.setParameter("nome", "%" + nome + "%")
				.setParameter("taxaInicial", taxaFreteInicial)
				.setParameter("taxaFinal", taxaFreteFinal)
				.getResultList();
	}

}
