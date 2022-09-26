package br.com.aceleragep.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aceleragep.entities.ListaEntity;
import br.com.aceleragep.repository.ListaRepository;

@Service
public class ListaService {

	@Autowired
	private ListaRepository listaRepository;

	@Transactional
	public ListaEntity cria(ListaEntity lista) {
		return listaRepository.save(lista);
	}

	@Transactional
	public ListaEntity alterar(ListaEntity lista) {
		return listaRepository.save(lista);
	}

	@Transactional
	public void remover(ListaEntity lista) {
		listaRepository.delete(lista);
	}

	public ListaEntity buscaPeloId(Long id) {
		return listaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi encontrada lista pelo id: " + id));
	}

	public List<ListaEntity> listaTodos() {
		return listaRepository.findAll();
	}
	
}
