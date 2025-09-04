package dev.ropimasi.curso.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;




@JsonRootName(value = "culinaria")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cozinha {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//	@JsonIgnore
	//	@JsonProperty("titulo")
	@Column(nullable = false)
	private String nome;

}
