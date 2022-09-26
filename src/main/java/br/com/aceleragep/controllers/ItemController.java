package br.com.aceleragep.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aceleragep.converts.ItemConvert;
import br.com.aceleragep.dtos.inputs.ItemInput;
import br.com.aceleragep.dtos.inputs.ListaInput;
import br.com.aceleragep.dtos.outputs.ItemOutput;
import br.com.aceleragep.dtos.outputs.ListaOutput;
import br.com.aceleragep.entities.ItemEntity;
import br.com.aceleragep.entities.ListaEntity;
import br.com.aceleragep.services.ItemService;
import br.com.aceleragep.services.ListaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Itens")
@RestController
@RequestMapping("/api/itens")
@CrossOrigin(origins = "*")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemConvert itemConvert;
	
	@Autowired
	private ListaService listaService;
	
	@Operation(summary = "Lista itens",description = "Lista os itens")
	@GetMapping("/{id}/itens-da-lista")
	public List<ItemOutput> listaItens(@PathVariable Long id) {
		List<ItemEntity> listaTodosItens = itemService.listaItensPelaLista(id);
		return itemConvert.entityToOutput(listaTodosItens);
	}
	
	@Operation(summary = "Cria item",description = "Cria um item para a lista")
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItemOutput criaItem(@Valid @RequestBody ItemInput item) {
		ItemEntity itemEntity = itemConvert.inputToEntity(item);
		convertListas(item, itemEntity);
		itemEntity.setConcluido(false);
		ItemEntity itemCriado = itemService.cria(itemEntity);
		return itemConvert.entityToOutput(itemCriado);
	}
	
//	@Operation(summary = "Cria lista",description = "Cria a lista")
//	@PostMapping
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public ListaOutput cria(@Valid @RequestBody ListaInput lista)  {
//		ListaEntity listaEntity = listaConvert.inputToEntity(lista);
//		ListaEntity listaCriada = listaService.cria(listaEntity);
//		return listaConvert.entityToOutput(listaCriada);
//	}
	
	@Operation(summary = "Altera item",description = "Altera um item para a lista")
	@PutMapping("/{id}")
	public ItemOutput alteraItem(@PathVariable Long id, @Valid @RequestBody ItemInput itemInput) {
		ItemEntity itemEntity = itemService.buscaPeloId(id);
		itemConvert.copyDataInputToEntity(itemInput, itemEntity);
		convertListas(itemInput, itemEntity);
		ItemEntity itemAlterado = itemService.alterar(itemEntity);
		return itemConvert.entityToOutput(itemAlterado);
	}
	
	@Operation(summary = "Conclui item",description = "Conclui um item para a lista")
	@PutMapping("/{id}/concluido")
	public ItemOutput itemConcluido(@PathVariable Long id) {
		ItemEntity itemEntity = itemService.buscaPeloId(id);
		itemEntity.setConcluido(true);
		ItemEntity itemAlterado = itemService.alterar(itemEntity);
		return itemConvert.entityToOutput(itemAlterado);
	}
	
	@Operation(summary = "Não conclui item",description = "Não conclui item para a lista")
	@PutMapping("/{id}/nao-concluido")
	public ItemOutput itemNaoConcluido(@PathVariable Long id) {
		ItemEntity itemEntity = itemService.buscaPeloId(id);
		itemEntity.setConcluido(false);
		ItemEntity itemAlterado = itemService.alterar(itemEntity);
		return itemConvert.entityToOutput(itemAlterado);
	}
	
	@Operation(summary = "Deleta item",description = "Deleta um item para a lista")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeLivro(@PathVariable Long id) {
		ItemEntity itemEntity = itemService.buscaPeloId(id);
		itemService.remover(itemEntity);
	}
	
	private void convertListas(ItemInput itemInput, ItemEntity itemEntity) {
		itemEntity.setLista(listaService.buscaPeloId(itemInput.getListaId()));
//		List<ListaEntity> listas = new ArrayList<>();
//		for (Long listaId : itemInput.getLista()) {
//			itemInput.add(listaService.buscaPeloId(listaId));
//		}
//		livroEntity.setAutores(autores);
	}
	
}
