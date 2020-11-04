package br.edu.ifg.luziania.pw.rest.form;

public class DepartamentoForm {
	
	private String nome;
	private String descricao;

	public String getNome() {
		return nome;
	}
	public String getDescricao() { return descricao; }



	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescricao(String descricao) { this.descricao = descricao; }

	public DepartamentoForm(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public DepartamentoForm() {
		super();
	}

	@Override
	public String toString() {
		return "DepartamentoForm [nome=" + nome +
				" descricao=" + descricao + "," +
				"]";
	}	
	
	

}
