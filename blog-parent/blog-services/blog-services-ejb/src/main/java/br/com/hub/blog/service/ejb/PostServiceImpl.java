package br.com.hub.blog.service.ejb;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.hub.blog.dao.api.PostDAO;
import br.com.hub.blog.model.Post;
import br.com.hub.blog.services.api.PostService;

@Stateless
public class PostServiceImpl implements PostService {

	@Inject
	private PostDAO postDAO;
	
	@Override
	public void save(Post post) {
		postDAO.save(post);
	}

	@Override
	public List<Post> findAll() {
		return postDAO.findAll();
	}

}
