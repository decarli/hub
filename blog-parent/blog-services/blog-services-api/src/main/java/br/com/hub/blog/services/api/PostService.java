package br.com.hub.blog.services.api;

import java.util.List;

import br.com.hub.blog.model.Post;

public interface PostService {
	
	public void save(Post post);
	
	public List<Post> findAll();
}
