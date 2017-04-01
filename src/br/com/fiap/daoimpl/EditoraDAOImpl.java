package br.com.fiap.daoimpl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EditoraDAO;
import br.com.fiap.entity.Editora;

public class EditoraDAOImpl extends GenericDAOImpl<Editora, Integer> implements EditoraDAO {

	public EditoraDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
}
