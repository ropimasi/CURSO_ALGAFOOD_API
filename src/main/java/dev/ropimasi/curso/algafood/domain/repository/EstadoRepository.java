package dev.ropimasi.curso.algafood.domain.repository;

import java.util.List;
import dev.ropimasi.curso.algafood.domain.model.Estado;




public interface EstadoRepository {

	List<Estado> listar();
	Estado buscar(Long id);
	Estado salvar(Estado estado);
	void remover(Long ig);

}
