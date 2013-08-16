package br.berdugo.vpsa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "funcionario")
@SequenceGenerator(name = "funcionario_seq", allocationSize = 1, initialValue = 1, sequenceName = "funcionario_seq")
public class Funcionario {

	@Id
	@GeneratedValue(generator = "funcionario_seq", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = true, unique = true)
	private Long idVpsaRepresentante;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "{messages.funcionario.validacao.nome}")
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String codigoRFID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdVpsaRepresentante() {
		return idVpsaRepresentante;
	}

	public void setIdVpsaRepresentante(Long idVpsaRepresentante) {
		this.idVpsaRepresentante = idVpsaRepresentante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCodigoRFID() {
		return codigoRFID;
	}

	public void setCodigoRFID(String codigoRFID) {
		this.codigoRFID = codigoRFID;
	}
}
