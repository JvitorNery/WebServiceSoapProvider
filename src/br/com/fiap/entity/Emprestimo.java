package br.com.fiap.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_EMPRESTIMO")
@SequenceGenerator(name="seqEmprestimo",sequenceName="SQ_TB_EMPRESTIMO",allocationSize=1)
public class Emprestimo {

	
	@Id
	@Column(name="CD_Emprestimo", nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqEmprestimo")
	private int id;
	
	@Column(name="dt_emprestimo",nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar data_emprestimo;
	
	@Column(name="dt_retorno",nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar data_retorno;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData_emprestimo() {
		return data_emprestimo;
	}

	public void setData_emprestimo(Calendar data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}

	public Calendar getData_retorno() {
		return data_retorno;
	}

	public void setData_retorno(Calendar data_retorno) {
		this.data_retorno = data_retorno;
	}
	
	public Emprestimo(){
		super();
	}
	
	public Emprestimo(int id, Calendar data_emprestimo, Calendar data_retorno) {
		super();
		this.id = id;
		this.data_emprestimo = data_emprestimo;
		this.data_retorno = data_retorno;
	}
	
	
	
	
}
