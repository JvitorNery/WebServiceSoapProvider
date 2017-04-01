package br.com.fiap.bo;

import javax.persistence.EntityManager;

import org.apache.axis.AxisFault;

import br.com.fiap.dao.ExemplarDAO;
import br.com.fiap.daoimpl.ExemplarDAOImpl;
import br.com.fiap.entity.Exemplar;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class ExemplarBO {
	
	public EntityManager newEntitymanager(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
	}
	
public void cadastrar(Exemplar Exemplar) throws AxisFault, DBException, IdNotFoundException {
		
		EntityManager em = newEntitymanager();
		
		ExemplarDAO dao = new ExemplarDAOImpl(em);
		
		dao.cadastrar(Exemplar);
		dao.salvar();
	}
	
	public Exemplar buscar(int codigo){
		EntityManager em = newEntitymanager();
		ExemplarDAO dao = new ExemplarDAOImpl(em);
		Exemplar Exemplar = dao.pesquisar(codigo);
		em.close();
		return Exemplar;
	}
	
public void remover(int codigo) throws AxisFault{
		
		EntityManager em = newEntitymanager();
		
		
		ExemplarDAO dao = new ExemplarDAOImpl(em);
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
	
	public void atualizar(Exemplar Exemplar) throws AxisFault{
		EntityManager em = newEntitymanager();
		
		ExemplarDAO dao = new ExemplarDAOImpl(em);
		
		dao.alterar(Exemplar);
		try {
			dao.salvar();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AxisFault("Erro ao alterar");
		}
		
	}

}
