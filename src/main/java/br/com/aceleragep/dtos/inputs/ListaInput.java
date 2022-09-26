package br.com.aceleragep.dtos.inputs;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaInput {

	@NotEmpty(message = "O título é obrigatório!")
	@Length(message = "O título deve ter até 100 caracteres!", min = 1, max = 100)
	private String titulo;
	
}
