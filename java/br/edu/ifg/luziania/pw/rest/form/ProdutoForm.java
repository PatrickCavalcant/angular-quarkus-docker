package br.edu.ifg.luziania.pw.rest.form;

import java.math.BigDecimal;

public class ProdutoForm {

	private String titulo;
	private String detalhe;
	private BigDecimal preco;
	private String sobrenome;
	private String tecnologias;

	public String getTitulo() {	return titulo;	}
	public String getDetalhe() { return detalhe; }
	public BigDecimal getPreco() { return preco; }


	public void setTitulo(String titulo) { this.titulo = titulo; }
	public void setDetalhe(String detalhe) { this.detalhe = detalhe; }
	public void setPreco(BigDecimal preco) { this.preco = preco; }


	public ProdutoForm(String titulo, String detalhe, BigDecimal preco) {
		super();
		this.titulo = titulo;
		this.detalhe = detalhe;
		this.preco = preco;
	}

	public ProdutoForm() {
		super();
	}

	@Override
	public String toString() {
		return "Produto [" +
				" titulo=" + titulo + "," +
				" detalhe=" + detalhe + "," +
				" preco=" + preco + "," +
				"]";
	}

}
