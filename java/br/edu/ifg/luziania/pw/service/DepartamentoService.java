package br.edu.ifg.luziania.pw.service;

import br.edu.ifg.luziania.pw.model.Departamento;
import br.edu.ifg.luziania.pw.rest.form.DepartamentoForm;

import java.util.List;

public interface DepartamentoService {

	List<Departamento> lista();

	long cria(Departamento encontro);

	Departamento porId(long id);

	void apaga(long id);

	Departamento atualiza(long id, DepartamentoForm departamentoForm);


}
