package br.edu.ifg.luziania.pw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String descricao;

	public Departamento() {
	}	

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Departamento(String nome) {
		this.nome = nome;
		this.descricao = descricao;

	}

	public String getNome() { return nome; }
	public String getDescricao() { return descricao; }

	public void setNome(String nome) { this.nome = nome; }
	public void setDescricao(String descricao) { this.descricao = descricao; }

	@Override
	public String toString() {
		return "Departamento [titulo=" + nome + "]";
	}

}
