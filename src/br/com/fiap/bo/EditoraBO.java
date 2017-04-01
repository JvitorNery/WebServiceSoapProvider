package br.com.fiap.bo;

import javax.persistence.EntityManager;

import org.apache.axis.AxisFault;

import br.com.fiap.dao.EditoraDAO;
import br.com.fiap.daoimpl.EditoraDAOImpl;
import br.com.fiap.entity.Editora;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class EditoraBO {
	
	public EntityManager newEntitymanager(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
	}
	
public void cadastrar(Editora Editora) throws AxisFault, DBException, IdNotFoundException {
		
		EntityManager em = newEntitymanager();
		
		EditoraDAO dao = new EditoraDAOImpl(em);
		
		dao.cadastrar(Editora);
		dao.salvar();
	}
	
	public Editora buscar(int codigo){
		EntityManager em = newEntitymanager();
		EditoraDAO dao = new EditoraDAOImpl(em);
		Editora Editora = dao.pesquisar(codigo);
		em.close();
		return Editora;
	}
	
public void remover(int codigo) throws AxisFault{
		
		EntityManager em = newEntitymanager();
		
		
		EditoraDAO dao = new EditoraDAOImpl(em);
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
	
	public void atualizar(Editora Editora) throws AxisFault{
		EntityManager em = newEntitymanager();
		
		EditoraDAO dao = new EditoraDAOImpl(em);
		
		dao.alterar(Editora);
		try {
			dao.salvar();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AxisFault("Erro ao alterar");
		}
		
	}

}
