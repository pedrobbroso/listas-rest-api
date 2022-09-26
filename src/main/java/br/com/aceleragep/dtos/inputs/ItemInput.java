package br.com.aceleragep.dtos.inputs;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemInput {
	
	@NotEmpty(message = "O título é obrigatório!")
	@Length(message = "O título deve ter até 100 caracteres!", min = 1, max = 100)
	private String titulo;
	
	@NotNull(message = "A lista é obrigatória!")
	private Long listaId;

}
