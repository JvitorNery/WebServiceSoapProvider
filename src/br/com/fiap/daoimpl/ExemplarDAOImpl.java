package br.com.fiap.daoimpl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ExemplarDAO;
import br.com.fiap.entity.Exemplar;

public class ExemplarDAOImpl extends GenericDAOImpl<Exemplar,Integer> implements ExemplarDAO {

	public ExemplarDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	

}
