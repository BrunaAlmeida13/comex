package br.com.alura.comex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.comex.modelo.CategoriaEntity;

//Por ser interface não necessita anotação
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

	List<CategoriaEntity> findAllById(Long id);
	
}
