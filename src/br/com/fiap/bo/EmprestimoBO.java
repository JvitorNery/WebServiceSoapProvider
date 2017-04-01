package br.com.fiap.bo;

import javax.persistence.EntityManager;

import org.apache.axis.AxisFault;

import br.com.fiap.dao.EmprestimoDAO;
import br.com.fiap.daoimpl.EmprestimoDAOImpl;
import br.com.fiap.entity.Emprestimo;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class EmprestimoBO {
	
	public EntityManager newEntitymanager(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
	}
	
public void cadastrar(Emprestimo Emprestimo) throws AxisFault, DBException, IdNotFoundException {
		
		EntityManager em = newEntitymanager();
		
		EmprestimoDAO dao = new EmprestimoDAOImpl(em);
		
		dao.cadastrar(Emprestimo);
		dao.salvar();
	}
	
	public Emprestimo buscar(int codigo){
		EntityManager em = newEntitymanager();
		EmprestimoDAO dao = new EmprestimoDAOImpl(em);
		Emprestimo Emprestimo = dao.pesquisar(codigo);
		em.close();
		return Emprestimo;
	}
	
public void remover(int codigo) throws AxisFault{
		
		EntityManager em = newEntitymanager();
		
		
		EmprestimoDAO dao = new EmprestimoDAOImpl(em);
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
	
	public void atualizar(Emprestimo Emprestimo) throws AxisFault{
		EntityManager em = newEntitymanager();
		
		EmprestimoDAO dao = new EmprestimoDAOImpl(em);
		
		dao.alterar(Emprestimo);
		try {
			dao.salvar();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AxisFault("Erro ao alterar");
		}
		
	}

}
