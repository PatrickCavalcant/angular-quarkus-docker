package br.edu.ifg.luziania.pw.rest;

import br.edu.ifg.luziania.pw.model.Departamento;
import br.edu.ifg.luziania.pw.rest.form.DepartamentoForm;
import br.edu.ifg.luziania.pw.service.DepartamentoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/departamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartamentoResource {

	@Inject
	DepartamentoService departamentoService;

	@GET
	public List<Departamento> lista() {
		return departamentoService.lista();
	}
	
	@POST
	@Transactional
	@Path("/criar")
	public Response cria(Departamento departamento) {
		long id = departamentoService.cria(departamento);
		URI uri = URI.create("http://localhost:8080/" + id);
		return Response.created(uri).build();
	}
	
	@PUT
	@Path("{id}")
	@Transactional
	public Response atualiza(@PathParam("id") long id, DepartamentoForm departamentoForm) {
		Departamento departamento = departamentoService.atualiza(id, departamentoForm);
		URI uri = URI.create("http://localhost:8080/" + departamento.getId());
		return Response.created(uri).build();		
	}
	
	@GET
	@Path("{id}")
	public Departamento porId(@PathParam("id") long id) {
		return departamentoService.porId(id);
	}
	
	@DELETE
	@Path("{id}")
	@Transactional
	public void apaga(@PathParam("id") long id) {
		Departamento departamento = departamentoService.porId(id);
		if(departamento == null) {
			throw new WebApplicationException(404);
		}
		departamentoService.apaga(id);
	}
}
