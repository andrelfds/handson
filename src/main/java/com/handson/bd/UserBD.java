package com.handson.bd;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.handson.entity.Address;
import com.handson.entity.User;
import com.handson.infra.AppBD;


public class UserBD extends AppBD<User, Long> {

	@PersistenceContext
	private EntityManager	em;
	private List<User>		users;
	
	@PostConstruct
	void init() {
		this.setEntityManager(em);
	}
	
    /**
     * Default constructor. 
     */
    public UserBD() {
    	users = new ArrayList<User>();
    }
    
    @Override
    public User save(User entity) {
    	// TODO Auto-generated method stub
    	return super.save(entity);
    }
    
    @Override
    public void remove(User entity) {
    	// TODO Auto-generated method stub
    	super.remove(entity);
    }
    
    @Override
    public User update(User entity) {
    	// TODO Auto-generated method stub
    	return super.update(entity);
    }

	@SuppressWarnings("unchecked")
	public List<User> listAddress() {
		Query query = em.createNamedQuery("address.list");
		users = query.getResultList();
		return users;
	}
	
	@Override
	public User find(Long id) {
		// TODO Auto-generated method stub
		return super.find(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		Query query = em.createNamedQuery("user.list");
		users = query.getResultList();
		return users;
	}

	
	public User findUserByPassword(User user) throws Exception {
		Query query = em.createNamedQuery("user.login").setParameter("name", user.getName()).setParameter("password", user.getPassword());
		if (query.getSingleResult() == null) {
			throw new Exception("Usuario inexistente ou senha errada");
		} else {
			user = (User) query.getSingleResult();
			user.setStatus((byte) 1);
			em.persist(user);
			return user;
		}
	}

	public boolean findUserLogado(User user) throws Exception {
		Query query = em.createNamedQuery("user.logado").setParameter("name", user.getName());
		if (query.getFirstResult() == 1) {
			return true;
		}
		return false;
	}


}
