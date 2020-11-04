package br.edu.ifg.luziania.pw.rest;

import br.edu.ifg.luziania.pw.model.Produto;
import br.edu.ifg.luziania.pw.rest.form.ProdutoForm;
import br.edu.ifg.luziania.pw.service.ProdutoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

	@Inject
	ProdutoService userService;

	@GET
	public List<Produto> lista() {
		System.out.println(userService.lista());
		return userService.lista();
	}
	
	@POST
	@Transactional
	public Response cria(Produto produto) {
		long id = userService.cria(produto);
		URI uri = URI.create("http://localhost:8080/" + id);
		return Response.created(uri).build();
	}
	
	@PUT
	@Path("{id}")
	@Transactional
	public Response atualiza(@PathParam("id") long id, ProdutoForm produtoForm) {
		Produto user = userService.atualiza(id, produtoForm);
		URI uri = URI.create("http://localhost:8080/" + user.getId());
		return Response.created(uri).build();		
	}
	
	@GET
	@Path("{id}")
	public Produto porId(@PathParam("id") long id) {
		return userService.porId(id);
	}
	
	@DELETE
	@Path("{id}")
	@Transactional
	public void apaga(@PathParam("id") long id) {
		Produto produto = userService.porId(id);
		if(produto == null) {
			throw new WebApplicationException(404);
		}
		userService.apaga(id);
	}
}
