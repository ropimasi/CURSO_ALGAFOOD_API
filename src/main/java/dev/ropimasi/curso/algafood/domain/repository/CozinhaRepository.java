package dev.ropimasi.curso.algafood.domain.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import dev.ropimasi.curso.algafood.domain.model.Cozinha;




@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

	List<Cozinha> findTodasByNomeContaining(String nome);

	Optional<Cozinha> findUnicaByNome(String nome);

	boolean existsByNome(String nome);

}
