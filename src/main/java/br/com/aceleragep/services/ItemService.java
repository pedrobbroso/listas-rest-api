package br.com.aceleragep.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aceleragep.entities.ItemEntity;
import br.com.aceleragep.entities.ListaEntity;
import br.com.aceleragep.repository.ItensRepository;

@Service
public class ItemService {

	@Autowired
	private ItensRepository itensRepository;
	
	@Transactional
	public ItemEntity cria(ItemEntity itemEntity) {
		return itensRepository.save(itemEntity);
	}
	
	@Transactional
	public ItemEntity alterar(ItemEntity itemEntity) {
		return itensRepository.save(itemEntity);
	}
	
	@Transactional
	public void remover(ItemEntity itemEntity) {
		itensRepository.delete(itemEntity);
	}
	
	public ItemEntity buscaPeloId(Long id) {
		return itensRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi encontrado item pelo id: " + id));
	}
	
	public List<ItemEntity> listaItensPelaLista(Long lista) {
		return itensRepository.findAllByListaId(lista);
	}
	
}
