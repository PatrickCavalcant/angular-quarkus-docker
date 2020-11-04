package br.edu.ifg.luziania.pw.service.impl;

import br.edu.ifg.luziania.pw.model.Produto;
import br.edu.ifg.luziania.pw.rest.form.ProdutoForm;
import br.edu.ifg.luziania.pw.service.ProdutoService;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Produto> lista() {
		return em.createQuery("select e from Produto e", Produto.class).getResultList();
	}

	@Override
	@Transactional
	public long cria(Produto produto) {
		em.persist(produto);
		return produto.getId();
	}

	@Override
	public Produto porId(long id) {
		return em.find(Produto.class, id);
	}

	@Override
	@Transactional
	public void apaga(long id) {
		Produto produto = porId(id);
		em.remove(produto);
	}

	@Override
	@Transactional
	public Produto atualiza(long id, ProdutoForm produtoForm) {
		Produto produto = porId(id);
		produto.setTitulo(produtoForm.getTitulo());
		produto.setDetalhe(produtoForm.getDetalhe());
		produto.setPreco(produtoForm.getPreco());

		return produto;
	}

}
