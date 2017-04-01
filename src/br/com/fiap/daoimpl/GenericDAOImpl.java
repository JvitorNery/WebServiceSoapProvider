package br.com.fiap.daoimpl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K>{
	
	private EntityManager em;
	
	private Class<T> classe;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {		
		this.em = em;
		classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
							.getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entity){
		em.persist(entity);
	}
	
	@Override
	public void alterar(T entity){
		em.merge(entity);
	}

	@Override
	public void remover(K codigo) throws IdNotFoundException {
		T entidade = pesquisar(codigo);
		if(entidade == null){
			throw new IdNotFoundException("Entidade não Encontrada");
		}
		em.remove(entidade);
		
	}

	@Override
	public T pesquisar(K codigo) {
		return em.find(classe,  codigo);
	}

	@Override
	public void salvar() throws DBException {
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new DBException("Erro ao executar commit");
		}
		
	}
	
	
}
