package br.com.aceleragep.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aceleragep.dtos.inputs.ItemInput;
import br.com.aceleragep.dtos.outputs.ItemOutput;
import br.com.aceleragep.entities.ItemEntity;

@Component
public class ItemConvert {

	@Autowired
	private ModelMapper model;

	public ItemOutput entityToOutput(ItemEntity itemEntity) {
		return model.map(itemEntity, ItemOutput.class);
	}

	public List<ItemOutput> entityToOutput(List<ItemEntity> itensEntity) {
		return itensEntity.stream().map(item -> this.entityToOutput(item)).collect(Collectors.toList());
	}

	public ItemEntity inputToEntity(ItemInput itemInput) {
		return model.map(itemInput, ItemEntity.class);
	}

	public void copyDataInputToEntity(ItemInput itemInput, ItemEntity itemEntity) {
		model.map(itemInput, itemEntity);
	}
	
}
