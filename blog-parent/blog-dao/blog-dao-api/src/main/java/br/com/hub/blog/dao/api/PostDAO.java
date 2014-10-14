package br.com.hub.blog.dao.api;

import java.util.List;

import br.com.hub.blog.model.Post;

public interface PostDAO {

	public void save(Post post);
	
	public List<Post> findAll();
}
