package Service;

import java.util.ArrayList;

import DAO.ComentarioDAO;
import DAO.ConnectionFactory;
import Model.Comentario;

import javax.persistence.EntityManager;

public class ComentarioService {
	EntityManager em = ConnectionFactory.getEntityManager();
	ComentarioDAO comentarioDAO = new ComentarioDAO(em);
	
	public void criar(Comentario comentario) {
		java.util.Date data = new java.util.Date();
		java.sql.Date dataSql = new java.sql.Date(data.getTime());
		comentario.setDataComentario(dataSql);
		comentarioDAO.criar(comentario);
	}
	
	public void atualizar(Comentario comentario) {
		java.util.Date data = new java.util.Date();
		java.sql.Date dataSql = new java.sql.Date(data.getTime());
		comentario.setDataAtualizacao(dataSql);
		comentarioDAO.atualizar(comentario);
	}
	
	public void excluir(Comentario comentario) {
		comentarioDAO.excluir(comentario);
	}

}
