package dev.ropimasi.curso.algafood.domain.repository;

import java.util.List;
import dev.ropimasi.curso.algafood.domain.model.Restaurante;




public interface RestauranteRepository {

	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Long id);

}
