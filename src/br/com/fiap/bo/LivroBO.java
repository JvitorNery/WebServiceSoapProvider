package br.com.fiap.bo;

import javax.persistence.EntityManager;

import org.apache.axis.AxisFault;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.daoimpl.LivroDAOImpl;
import br.com.fiap.entity.Livro;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class LivroBO {
	
	public EntityManager newEntitymanager(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
	}
	
public void cadastrar(Livro Livro) throws AxisFault, DBException, IdNotFoundException {
		
		EntityManager em = newEntitymanager();
		
		LivroDAO dao = new LivroDAOImpl(em);
		
		dao.cadastrar(Livro);
		dao.salvar();
	}
	
	public Livro buscar(int codigo){
		EntityManager em = newEntitymanager();
		LivroDAO dao = new LivroDAOImpl(em);
		Livro Livro = dao.pesquisar(codigo);
		em.close();
		return Livro;
	}
	
public void remover(int codigo) throws AxisFault{
		
		EntityManager em = newEntitymanager();
		
		
		LivroDAO dao = new LivroDAOImpl(em);
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
	
	public void atualizar(Livro Livro) throws AxisFault{
		EntityManager em = newEntitymanager();
		
		LivroDAO dao = new LivroDAOImpl(em);
		
		dao.alterar(Livro);
		try {
			dao.salvar();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AxisFault("Erro ao alterar");
		}
		
	}

}
