package br.com.fiap.bo;

import javax.persistence.EntityManager;

import org.apache.axis.AxisFault;

import br.com.fiap.dao.AutorDAO;
import br.com.fiap.daoimpl.AutorDAOImpl;
import br.com.fiap.entity.Autor;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class AutorBO {
	
	public EntityManager newEntitymanager(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
	}
	
public void cadastrar(Autor autor) throws AxisFault, DBException, IdNotFoundException {
		
		EntityManager em = newEntitymanager();
		
		AutorDAO dao = new AutorDAOImpl(em);
		
		dao.cadastrar(autor);
		dao.salvar();
	}
	
	public Autor buscar(int codigo){
		EntityManager em = newEntitymanager();
		AutorDAO dao = new AutorDAOImpl(em);
		Autor autor = dao.pesquisar(codigo);
		em.close();
		return autor;
	}
	
public void remover(int codigo) throws AxisFault{
		
		EntityManager em = newEntitymanager();
		
		
		AutorDAO dao = new AutorDAOImpl(em);
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
	
	public void atualizar(Autor autor) throws AxisFault{
		EntityManager em = newEntitymanager();
		
		AutorDAO dao = new AutorDAOImpl(em);
		
		dao.alterar(autor);
		try {
			dao.salvar();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AxisFault("Erro ao alterar");
		}
		
	}

}
