package br.edu.ifg.luziania.pw.service;

import br.edu.ifg.luziania.pw.model.Produto;
import br.edu.ifg.luziania.pw.rest.form.ProdutoForm;

import java.util.List;

public interface ProdutoService {

	List<Produto> lista();

	long cria(Produto User);

	Produto porId(long id);

	void apaga(long id);

	Produto atualiza(long id, ProdutoForm produtoForm);


}
