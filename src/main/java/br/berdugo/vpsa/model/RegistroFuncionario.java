package br.berdugo.vpsa.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.berdugo.vpsa.enums.TipoRegistro;

@Entity(name = "registro_funcionario")
@SequenceGenerator(name = "registro_seq", sequenceName = "registro_seq", allocationSize = 1, initialValue = 1)
public class RegistroFuncionario {

	@Id
	@GeneratedValue(generator = "registro_seq", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHora;
	
	@Enumerated(EnumType.STRING)
	private TipoRegistro tipo;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Funcionario funcionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public TipoRegistro getTipo() {
		return tipo;
	}

	public void setTipo(TipoRegistro tipo) {
		this.tipo = tipo;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}