package com.sbs.springboot.sbssb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbs.springboot.sbssb.entities.Aarti;

@Repository
public class AartiDAOImpl implements AartiDAO {

    // Defining field entityManager
	private EntityManager entityManager;
	
	// constructor injector for entity manager
	@Autowired
	public AartiDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	public Aarti saveAarti(Aarti aarti) {   
		// get the current hibernate session
		Session currentSession = 
				entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(aarti);
		return aarti;
	}

	public Aarti getAarti(int id) {	
		// get current session
		Session currentSession = 
				entityManager.unwrap(Session.class);
				
	   Aarti aarti = currentSession.get(Aarti.class, id);
	   return aarti;			
	}

	public List<Aarti> getAarties() {
		// get current session
		Session currentSession = 
				entityManager.unwrap(Session.class);
		
	   List<Aarti> aartis = currentSession.createQuery("from Aarti", 
						Aarti.class).getResultList();
		
	  return aartis; 
	}

	public int deleteAarti(int id) {
		// get current session
		Session currentSession = 
				entityManager.unwrap(Session.class);
		
		Query query = currentSession.
		    createQuery("delete from Aarti where id=:aartiId");
		query.setParameter("aartiId", id);     
		
		query.executeUpdate();	
		
		return id;
	}

}
