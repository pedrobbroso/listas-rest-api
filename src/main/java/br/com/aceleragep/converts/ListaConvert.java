package br.com.aceleragep.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aceleragep.dtos.inputs.ListaInput;
import br.com.aceleragep.dtos.outputs.ListaOutput;
import br.com.aceleragep.entities.ListaEntity;

@Component
public class ListaConvert {

	@Autowired
	private ModelMapper model;

	public ListaOutput entityToOutput(ListaEntity listaEntity) {
		return model.map(listaEntity, ListaOutput.class);
	}

	public List<ListaOutput> entityToOutput(List<ListaEntity> listasEntity) {
		return listasEntity.stream().map(listas -> this.entityToOutput(listas)).collect(Collectors.toList());
	}

	public ListaEntity inputToEntity(ListaInput listaInput) {
		return model.map(listaInput, ListaEntity.class);
	}

	public void copyDataInputToEntity(ListaInput listaInput, ListaEntity listaEntity) {
		model.map(listaInput, listaEntity);
	}
	
}
