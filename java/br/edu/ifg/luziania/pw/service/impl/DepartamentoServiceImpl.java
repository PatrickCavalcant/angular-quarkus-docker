package br.edu.ifg.luziania.pw.service.impl;

import br.edu.ifg.luziania.pw.model.Departamento;
import br.edu.ifg.luziania.pw.rest.form.DepartamentoForm;
import br.edu.ifg.luziania.pw.service.DepartamentoService;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DepartamentoServiceImpl implements DepartamentoService {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Departamento> lista() {
		return em.createQuery("select e from Departamento e", Departamento.class).getResultList();
	}

	@Override
	@Transactional
	public long cria(Departamento departamento) {
		em.persist(departamento);
		return departamento.getId();
	}

	@Override
	public Departamento porId(long id) {
		return em.find(Departamento.class, id);
	}

	@Override
	@Transactional
	public void apaga(long id) {
		Departamento departamento = porId(id);
		em.remove(departamento);
	}

	@Override
	@Transactional
	public Departamento atualiza(long id, DepartamentoForm departamentoForm) {
		Departamento departamento = porId(id);
		departamento.setNome(departamentoForm.getNome());
		departamento.setDescricao(departamentoForm.getDescricao());
		return departamento;
	}

}
