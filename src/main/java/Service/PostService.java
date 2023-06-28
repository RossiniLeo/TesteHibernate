package Service;

import DAO.ConnectionFactory;
import DAO.PostDAO;
import Model.Post;

import javax.persistence.EntityManager;
import java.util.List;

public class PostService {
	EntityManager em = ConnectionFactory.getEntityManager();
	PostDAO postDAO = new PostDAO(em);
	
	public void criar(Post post) {
		java.util.Date data = new java.util.Date();
		java.sql.Date dataSql = new java.sql.Date(data.getTime());
		post.setDataPost(dataSql);
		postDAO.criar(post);
	}

	public void excluir(Post post) {
		postDAO.excluir(post);
	}

	public void atualizar(Post post) {
		java.util.Date data = new java.util.Date();
		java.sql.Date dataSql = new java.sql.Date(data.getTime());
		post.setDataAtualizacao(dataSql);
		postDAO.atualizar(post);
	}
}
