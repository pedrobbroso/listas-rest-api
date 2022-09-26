package br.com.aceleragep.dtos.outputs;

import br.com.aceleragep.entities.ListaEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemOutput {

	private Long id;
	private String titulo;
	private Boolean concluido;
	private ListaEntity lista;
//	private List<ListaEntity> lista;

}
