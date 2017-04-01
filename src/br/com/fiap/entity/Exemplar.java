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
@Table(name="TB_EXEMPLAR")
@SequenceGenerator(name="seqExemplar",sequenceName="SQ_TB_EXEMPLAR",allocationSize=1)
public class Exemplar {
	
	
	@Id
	@Column(name="CD_Exemplar", nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqExemplar")
	private int id;
	
	@Column(name="dt_aquisicao",nullable=true)
	@Temporal(TemporalType.DATE)
	private Calendar data_aquisicao;
	
	@Column(name="nr_situacao",nullable=false)
	private int situacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData_aquisicao() {
		return data_aquisicao;
	}

	public void setData_aquisicao(Calendar data_aquisicao) {
		this.data_aquisicao = data_aquisicao;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	
	public Exemplar(){
		super();
	}
	
	public Exemplar(int id, Calendar data_aquisicao, int situacao) {
		super();
		this.id = id;
		this.data_aquisicao = data_aquisicao;
		this.situacao = situacao;
	}
	
	
}
