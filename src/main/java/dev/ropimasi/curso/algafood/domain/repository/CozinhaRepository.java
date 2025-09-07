package dev.ropimasi.curso.algafood.domain.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.ropimasi.curso.algafood.domain.model.Cozinha;




@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

	List<Cozinha> findTodasByNomeContaining(String nome);
	
	Optional<Cozinha> findUnicaByNome(String nome);
	
	boolean existsByNome(String nome);

}
