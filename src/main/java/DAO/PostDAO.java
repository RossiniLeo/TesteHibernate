package DAO;

import Model.Post;

import javax.persistence.EntityManager;
import java.util.List;

public class PostDAO {

    private EntityManager em;

    public PostDAO(EntityManager em) {
        this.em = em;
    }

    public void criar(Post post) {
        this.em.persist(post);
    }

    public void atualizar(Post post) {
        this.em.merge(post);
    }

    public void excluir(Post post) {
        post = em.merge(post);
        this.em.remove(post);
    }

    public List<Post> buscarTodos() {
        String jpql = "SELECT p FROM POST P";
        return	em.createQuery(jpql, Post.class).getResultList();
    }
}
