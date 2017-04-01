package br.com.fiap.entity;

import java.util.Calendar;

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
@Table(name="TB_AUTOR")
@SequenceGenerator(name="seqAutor",sequenceName="SQ_TB_AUTOR",allocationSize=1)
public class Autor {
	@Id
	@Column(name="CD_Autor", nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqAutor")
	private int id;
	@Column(name="NM_AUTOR", nullable=false, length=300)
	private String nome;
	@Column(name="DS_SEXO", nullable=false)
	private int sexo;
	@Column(name="NM_SOBRENOME", nullable=false)
	private String sobrenome;
	@Column(name="DT_NASC")
	@Temporal(TemporalType.DATE)
	private Calendar dt_nascimento;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Calendar getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(Calendar dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	
	public Autor(){
		super();
	}
	
	public Autor(int id, String nome, int sexo, String sobrenome, Calendar dt_nascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.sobrenome = sobrenome;
		this.dt_nascimento = dt_nascimento;
	}
	
}
