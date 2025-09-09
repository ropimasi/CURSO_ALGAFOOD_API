package dev.ropimasi.curso.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import dev.ropimasi.curso.algafood.domain.model.Restaurante;




public interface RestauranteRepositoryCustom {

	List<Restaurante> porNomeTaxaFreteEntre(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

	List<Restaurante> consulta(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}