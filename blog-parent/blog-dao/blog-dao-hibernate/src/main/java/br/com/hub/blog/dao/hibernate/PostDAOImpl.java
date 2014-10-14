package br.com.hub.blog.dao.hibernate;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.hub.blog.dao.api.PostDAO;
import br.com.hub.blog.model.Post;

@Stateless
public class PostDAOImpl implements PostDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(Post post) {
		if(post.getId() == null){
			entityManager.persist(post);
		}else{
			entityManager.merge(post);
		}
	}

	@Override
	public List<Post> findAll() {
		CriteriaQuery<Post> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Post.class);
		Root<Post> root = criteriaQuery.from(Post.class);
		criteriaQuery.select(root);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
