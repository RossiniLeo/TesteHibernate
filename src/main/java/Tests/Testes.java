package Tests;

import DAO.ComentarioDAO;
import DAO.ConnectionFactory;
import DAO.PostDAO;
import DAO.UsuarioDAO;
import Model.Comentario;
import Model.Post;
import Model.Usuario;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class Testes {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Leonardo", "leonardo@email.com", "123456");
        usuario.setUserID(1L);
        Post post = new Post(usuario, "Titulo Teste", "Corpo Teste");
        post.setPostID(1L);
        List<Comentario> comentarios = new ArrayList<>();
        Comentario comentario = new Comentario(post, usuario, "Comentario Teste");
        comentario.setComentarioID(1L);
        comentarios.add(comentario);

        EntityManager em = ConnectionFactory.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(em);
        PostDAO postDAO = new PostDAO(em);
        ComentarioDAO comentarioDAO = new ComentarioDAO(em);

        em.getTransaction().begin();

        usuarioDAO.criar(usuario);
        postDAO.criar(post);

        comentarioDAO.criar(comentario);
        post.setComentarios(comentarios);
        postDAO.atualizar(post);
    }
}
