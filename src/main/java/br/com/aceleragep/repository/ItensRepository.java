package br.com.aceleragep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aceleragep.entities.ItemEntity;

@Repository
public interface ItensRepository extends JpaRepository<ItemEntity, Long> {

	List<ItemEntity> findAllByListaId(Long lista);
	
}
