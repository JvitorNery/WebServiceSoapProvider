package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_EDITORA")
@SequenceGenerator(name="seqEditora",sequenceName="SQ_TB_EDITORA",allocationSize=1)
public class Editora {
	
	@Id
	@Column(name="CD_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqEditora")
	private int id;
	@Column(name="NM_CNPJ", nullable=false)
	private String cnpj;
	@Column(name="NM_NOME", nullable=false)
	private String nome;
	@Column(name="DS_ENDERECO")
	private String endereco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Editora(){
		super();
	}
	
	public Editora(int id, String cnpj, String nome, String endereco) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	
}
