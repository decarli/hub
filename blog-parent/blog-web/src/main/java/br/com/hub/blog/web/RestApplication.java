package br.com.hub.blog.web;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import br.com.hub.blog.model.Post;
import br.com.hub.blog.services.api.PostService;

@ApplicationPath("rest")
@Produces("application/json; charset=UTF-8")
public class RestApplication extends Application{

	@EJB
	private PostService postService;
	
	@PUT
	public Response save(Post post){
		postService.save(post);
		
		return Response.ok(post).build();
	}
	
	@GET
	@Path("findAll")
	public Response findAll(){
		List<Post> listPost = postService.findAll();
		return Response.ok(listPost).build();
	}
}