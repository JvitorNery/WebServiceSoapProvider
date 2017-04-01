package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_LIVRO")
@SequenceGenerator(name="seqLivro",sequenceName="SQ_TB_LIVRO",allocationSize=1)
public class Livro {
	
	@Id
	@Column(name="CD_ISBN", nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqLivro")
	private int isbn;
	@Column(name="NM_TITULO", nullable=false)
	private String titulo;
	@Column(name="VL_PRECO")
	private double preco;
	@Column(name="DT_LANC")
	@Temporal(TemporalType.DATE)
	private Calendar dt_lanacamento;
	@Lob
	@Column(name="FL_CAPA")
	private byte[] capa;
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Calendar getDt_lanacamento() {
		return dt_lanacamento;
	}
	public void setDt_lanacamento(Calendar dt_lanacamento) {
		this.dt_lanacamento = dt_lanacamento;
	}
	public byte[] getCapa() {
		return capa;
	}
	public void setCapa(byte[] capa) {
		this.capa = capa;
	}
	
	public Livro(){
		super();
	}
	
	public Livro(int isbn, String titulo, double preco, Calendar dt_lanacamento, byte[] capa) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.dt_lanacamento = dt_lanacamento;
		this.capa = capa;
	}
	
}
