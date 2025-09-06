package dev.ropimasi.curso.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.ropimasi.curso.algafood.domain.model.Estado;




@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {



}
