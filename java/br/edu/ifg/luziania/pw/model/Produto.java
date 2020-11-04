package br.edu.ifg.luziania.pw.model;
import io.quarkus.panache.common.Parameters;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue
	private long id;
	private String titulo;
	private String detalhe;
	private BigDecimal preco;


	public Produto() {
	}	

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Produto(String titulo, String detalhe, BigDecimal preco) {
		this.titulo = titulo;
		this.detalhe = detalhe;
		this.preco = preco;
	}

	public String getTitulo() {	return titulo;	}
	public String getDetalhe() { return detalhe; }
	public BigDecimal getPreco() { return preco; }


	public void setTitulo(String usuario) { this.titulo = usuario; }
	public void setDetalhe(String email) { this.detalhe = email; }
	public void setPreco(BigDecimal preco) { this.preco = preco; }


	@Override
	public String toString() {
		return "User [" +
				" titulo=" + titulo + "," +
				" detalhe=" + detalhe + "," +
				" preco=" + preco + "," +
				"]";
	}

}
