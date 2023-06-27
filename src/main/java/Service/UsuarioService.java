package Service;

import DAO.ConnectionFactory;
import DAO.UsuarioDAO;
import Model.Usuario;

import javax.persistence.EntityManager;

public class UsuarioService {

	EntityManager em = ConnectionFactory.getEntityManager();
	private UsuarioDAO usuarioDao = new UsuarioDAO(em);
	
	public void criar(Usuario usuario) {
		usuarioDao.criar(usuario);
	}

	public void atualizar(Usuario usuario) {
		usuarioDao.atualizar(usuario);
	}

	public void excluir(Usuario usuario) {
		usuarioDao.excluir(usuario);
	}
}	
