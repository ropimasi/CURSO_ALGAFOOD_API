package dev.ropimasi.curso.algafood.infrastructure.repository;

import java.util.List;
import org.springframework.stereotype.Component;
import dev.ropimasi.curso.algafood.domain.model.FormaPagamento;
import dev.ropimasi.curso.algafood.domain.repository.FormaPagamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;




@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;



	@Override
	public List<FormaPagamento> listar() {
		TypedQuery<FormaPagamento> query = manager.createQuery("from FormaPagamento", FormaPagamento.class);
		return query.getResultList();
	}



	@Override
	public FormaPagamento buscar(Long id) {
		return manager.find(FormaPagamento.class, id);
	}



	@Override
	@Transactional
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}



	@Override
	@Transactional
	public void remover(FormaPagamento formapagamento) {
		formapagamento = buscar(formapagamento.getId());
		manager.remove(formapagamento);
	}
}
