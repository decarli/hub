package br.com.hub.blog.web;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.hub.blog.model.Post;
import br.com.hub.blog.services.api.PostService;

@Path("post")
public class PostEndpoint{

	@EJB
	private PostService postService;

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	public Response save( Post post) {
		postService.save(post);

		return Response.ok(post).build();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	public Response findAll() {
		List<Post> findAll = postService.findAll();

		return Response.ok(findAll).build();
	}

}
