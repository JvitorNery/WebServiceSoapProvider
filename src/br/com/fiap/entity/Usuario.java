package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO")
@SequenceGenerator(name="seqUser",sequenceName="SQ_TB_USUARIO",allocationSize=1)
public class Usuario {	
	
	@Id
	@Column(name="CD_Usuario", nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqUser")
	private int id;
	
	@Column(name="nm_nome_usuario",nullable=false)
	private String nome_usuario;
	
	@Column(name="nm_nome",length=300,nullable=false)
	private String nome;
	
	@Column(name="nm_sobrenome",length=300,nullable=true)
	private String sobrenome;
	
	@Column(name="nr_cpf",length=20,nullable=false)
	private String cpf;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Usuario(){
		super();
	}
	
	public Usuario(int id, String nome_usuario, String nome, String sobrenome, String cpf) {
		super();
		this.id = id;
		this.nome_usuario = nome_usuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}
	
	
	
}
