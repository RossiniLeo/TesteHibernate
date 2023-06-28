package DAO;

import Model.Comentario;

import javax.persistence.EntityManager;
import java.util.List;

public class ComentarioDAO {
    private EntityManager em;

    public ComentarioDAO(EntityManager em) {
        this.em = em;
    }

    public void criar(Comentario comentario) {
        this.em.persist(comentario);
    }

    public void atualizar(Comentario comentario) {
        this.em.merge(comentario);
    }

    public void excluir(Comentario comentario) {
        comentario = em.merge(comentario);
        this.em.remove(comentario);
    }

    public List<Comentario> buscarTodos() {
        String jpql = "SELECT p FROM COMENTARIO P";
        return	em.createQuery(jpql, Comentario.class).getResultList();
    }
}
