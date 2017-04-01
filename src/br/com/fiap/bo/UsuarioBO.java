package br.com.fiap.bo;

import javax.persistence.EntityManager;

import org.apache.axis.AxisFault;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.daoimpl.UsuarioDAOImpl;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class UsuarioBO {
	
	public Usuario buscar(int codigo){
		EntityManager em = newEntitymanager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		Usuario user = dao.pesquisar(codigo);
		em.close();
		return user;
	}
	
	public void cadastrar(Usuario user) throws AxisFault, DBException, IdNotFoundException {
		
		EntityManager em = newEntitymanager();
		
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		
		dao.cadastrar(user);
		dao.salvar();
	}
	
	public EntityManager newEntitymanager(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
	}
	


	public void remover(int codigo) throws AxisFault{
		
		EntityManager em = newEntitymanager();
		
		
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		try {
			dao.remover(codigo);
			dao.salvar();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			throw new AxisFault("Erro ao Remover");
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AxisFault("Erro ao buscar ID");
		}
	}
	
	public void atualizar(Usuario user) throws AxisFault{
		EntityManager em = newEntitymanager();
		
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		
		dao.alterar(user);
		try {
			dao.salvar();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AxisFault("Erro ao alterar");
		}
		
	}

}
