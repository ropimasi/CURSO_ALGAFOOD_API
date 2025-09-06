package dev.ropimasi.curso.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.ropimasi.curso.algafood.domain.model.Restaurante;




@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
