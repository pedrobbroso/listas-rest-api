package br.com.aceleragep.controllers;

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
import br.com.aceleragep.converts.ListaConvert;
import br.com.aceleragep.dtos.inputs.ListaInput;
import br.com.aceleragep.dtos.outputs.ItemOutput;
import br.com.aceleragep.dtos.outputs.ListaOutput;
import br.com.aceleragep.entities.ItemEntity;
import br.com.aceleragep.entities.ListaEntity;
import br.com.aceleragep.services.ItemService;
import br.com.aceleragep.services.ListaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Listas")
@RestController
@RequestMapping("/api/listas")
@CrossOrigin(origins = "*")
public class ListaController {

	@Autowired
	private ListaService listaService;

	@Autowired
	private ListaConvert listaConvert;
	
////	@Operation(summary = "Cria lista",description = "Cria a lista")
//	@Operation(summary = "Lista a lista por id",description = "Lista a lista por id existente")
//	@GetMapping("/{id}")
//	public ListaOutput buscaAutorPorId(@PathVariable Long id) {
//		ListaEntity listaEntity = listaService.buscaPeloId(id);
//		return listaConvert.entityToOutput(listaEntity);
//	}

	@Operation(summary = "Cria lista",description = "Cria a lista")
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ListaOutput cria(@Valid @RequestBody ListaInput lista)  {
		ListaEntity listaEntity = listaConvert.inputToEntity(lista);
		ListaEntity listaCriada = listaService.cria(listaEntity);
		return listaConvert.entityToOutput(listaCriada);
	}
//	public ItemOutput entityToOutput(ItemEntity itemEntity) {
//		return model.map(itemEntity, ItemOutput.class);
//	}
//	
	@Operation(summary = "Altera lista",description = "Altera a lista")
	@PutMapping("/{id}")
	public ListaOutput altera(@PathVariable Long id, @Valid @RequestBody ListaInput lista) {
		ListaEntity listaEntity = listaService.buscaPeloId(id);
		listaConvert.copyDataInputToEntity(lista, listaEntity);
		ListaEntity listaAlterada = listaService.alterar(listaEntity);
		return listaConvert.entityToOutput(listaAlterada);
	}
	
//	@Operation(summary = "Cria lista",description = "Cria a lista")
	@Operation(summary = "Lista a lista por id",description = "Lista a lista por id existente")
	@GetMapping("/{id}")
	public ListaOutput buscaAutorPorId(@PathVariable Long id) {
		ListaEntity listaEntity = listaService.buscaPeloId(id);
		return listaConvert.entityToOutput(listaEntity);
	}
	
	@Operation(summary = "Deleta lista",description = "Deleta a lista por id existente")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeLista(@PathVariable Long id) {
		ListaEntity listaEntity = listaService.buscaPeloId(id);
		listaService.remover(listaEntity);
	}
	
	@Operation(summary = "Lista todos",description = "Lista todas as listas")
	@GetMapping
	public List<ListaOutput> listaTodos() {
		List<ListaEntity> listaTodos = listaService.listaTodos();
		return listaConvert.entityToOutput(listaTodos);
	}
	
}
