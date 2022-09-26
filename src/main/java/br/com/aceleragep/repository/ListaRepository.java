package br.com.aceleragep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aceleragep.entities.ListaEntity;

@Repository
public interface ListaRepository extends JpaRepository<ListaEntity, Long> {

	
	
}
