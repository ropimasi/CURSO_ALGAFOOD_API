package dev.ropimasi.curso.algafood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import dev.ropimasi.curso.algafood.domain.model.Restaurante;
import dev.ropimasi.curso.algafood.domain.repository.RestauranteRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;




@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryCustom { // SDJ implementação customizada.

	@PersistenceContext
	private EntityManager em;



	@Override
	public List<Restaurante> porNomeTaxaFreteEntre(String nome, BigDecimal taxaFreteInicial,
			BigDecimal taxaFreteFinal) {
		var jpql = "from Restaurante where nome like :nome and taxaFrete between :taxaInicial and :taxaFinal";

		return em.createQuery(jpql, Restaurante.class).setParameter("nome", "%" + nome + "%")
				.setParameter("taxaInicial", taxaFreteInicial).setParameter("taxaFinal", taxaFreteFinal)
				.getResultList();
	}

	/*Consulta dinâmica com JPQL.
	@Override
	public List<Restaurante> consulta(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		var jpql = new StringBuilder();
		jpql.append("from Restaurante where 0=0 ");
	
		var parametros = new HashMap<String, Object>();
	
		if (StringUtils.hasLength(nome)) {
			jpql.append("and nome like :nome ");
			parametros.put("nome", "%" + nome + "%");
		}
	
		if (taxaFreteInicial != null) {
			jpql.append("and taxaFrete >= :taxaInicial ");
			parametros.put("taxaInicial", taxaFreteInicial);
		}
	
		if (taxaFreteFinal != null) {
			jpql.append("and taxaFrete <= :taxaFinal ");
			parametros.put("taxaFinal", taxaFreteFinal);
		}
	
		TypedQuery<Restaurante> query =  em.createQuery(jpql.toString(), Restaurante.class);
		
		parametros.forEach((chave, valor) -> query.setParameter(chave, valor));
		 
		return query.getResultList();
	}*/



	/* Consulta dinâmica com Criteria Query */
	@Override
	public List<Restaurante> consulta(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Restaurante> restauranteCriteriaQuery = criteriaBuilder.createQuery(Restaurante.class);
		Root<Restaurante> restauranteRoot = restauranteCriteriaQuery.from(Restaurante.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (StringUtils.hasText(nome)) {
			predicates.add(criteriaBuilder.like(restauranteRoot.get("nome"), "%" + nome + "%"));
		}

		if (taxaFreteInicial != null) {
			predicates.add(criteriaBuilder.greaterThanOrEqualTo(restauranteRoot.get("taxaFrete"), taxaFreteInicial));

		}

		if (taxaFreteFinal != null) {
			predicates.add(criteriaBuilder.lessThanOrEqualTo(restauranteRoot.get("taxaFrete"), taxaFreteFinal));
		}

		restauranteCriteriaQuery.where(predicates.toArray(new Predicate[0]));

		TypedQuery<Restaurante> restauranteTypedQuery = em.createQuery(restauranteCriteriaQuery);
		return restauranteTypedQuery.getResultList();
	}

}
