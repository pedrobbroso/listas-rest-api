package br.com.aceleragep.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_itens")
@Getter
@Setter
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(length = 100, name = "titulo")
	private String titulo;
	
	@Column(name = "concluido")
	private Boolean concluido;
	
	//@JoinTable(name = "tb_itens_listas", joinColumns = @JoinColumn(name = "itens_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "itens_id", referencedColumnName = "id"))
	@JoinColumn(name = "listas_id")
	@ManyToOne
	private ListaEntity lista;
	
}
