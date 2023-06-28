package DAO;

import Model.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDAO {

    private EntityManager em;

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }

    public void criar(Usuario usuario) {
        this.em.persist(usuario);
    }

    public void atualizar(Usuario usuario) {
        this.em.merge(usuario);
    }

    public void excluir(Usuario usuario) {
        usuario = em.merge(usuario);
        this.em.remove(usuario);
    }

    public List<Usuario> buscarTodos() {
        String jpql = "SELECT p FROM USUARIO P";
        return	em.createQuery(jpql, Usuario.class).getResultList();
    }
}
