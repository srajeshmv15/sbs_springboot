package com.sbs.springboot.sbssb.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;



import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbs.springboot.sbssb.entities.Pooja;

@Repository
public class PoojaDAOImpl implements PoojaDAO {

	 // Defining field entityManager
		private EntityManager entityManager;
		
	// constructor injector for entity manager
		@Autowired
		public PoojaDAOImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
	public Pooja savePooja(Pooja pooja) {
		// get the current hibernate session
		Session currentSession = 
						entityManager.unwrap(Session.class);
				
		currentSession.saveOrUpdate(pooja);
		return pooja;
	}

	public Pooja getPooja(int id) {
		// get current session
				Session currentSession = 
						entityManager.unwrap(Session.class);
						
			   Pooja pooja = currentSession.get(Pooja.class, id);
			   return pooja;			

	}

	public List<Pooja> getPoojas() {
		// get current session
				Session currentSession = 
						entityManager.unwrap(Session.class);
				
			   List<Pooja> poojas = currentSession.createQuery("from Pooja", 
								Pooja.class).getResultList();
				
			  return poojas; 
	}

	public int deletePooja(int id) {
		// get current session
				Session currentSession = 
						entityManager.unwrap(Session.class);
				
				Query query = currentSession.
				    createQuery("delete from Pooja where id=:poojaId");
				query.setParameter("poojaId", id);     
				
				query.executeUpdate();	
				
				return id;
	}

	public List<Pooja> getPoojas(String queryString, Date pDate) {
		List<Pooja> poojas = null;
		// get current session
		Session currentSession = 
				entityManager.unwrap(Session.class);
		
		Query query = currentSession.createQuery(queryString, Pooja.class);
		query.setParameter("pDate", pDate);
         
		return poojas = query.getResultList();
		
	}

}
