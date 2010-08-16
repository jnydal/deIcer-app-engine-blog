package no.jorundnydal.deicer.service.impl;

import java.util.List;

import java.util.logging.Logger;

import no.jorundnydal.deicer.dao.UserDAO;
import no.jorundnydal.deicer.entity.Admin;
import no.jorundnydal.deicer.entity.User;
import no.jorundnydal.deicer.service.UserService;
import no.jorundnydal.deicer.shop.entity.Customer;

import com.google.appengine.api.datastore.Key;


/*
 * user manager implementation
 * 
 * handles user related buisness logic
 * 
 */
public class UserServiceImpl implements UserService {
	
	private static final Logger log = Logger.getLogger(UserService.class.getName());
	  
	private UserDAO userDAO;
	
	public Admin storeAdmin(Admin u) {
		
		Admin user = new Admin();
		user.setId(u.getId());
		user.setPassword(u.getPassword());
		
		userDAO.saveObject(user,Admin.class);
		
		return user;
		
	}
	
	public Customer storeCustomer(Customer u) {
		
		Customer user = new Customer();
		user.setId(u.getId());
		user.setPassword(u.getPassword());
		
		log.info("storing user");
		userDAO.saveObject(user,Customer.class);
		
		return user;
		
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<User> getAllUsers() {
		
		return userDAO.findAll();
		
	}

	public List<Admin> getAllAdmins() {

		return userDAO.findAllAdmins();
		
	}
	
	@Override
	public Admin getAdmin(Key id) {

		return (Admin) userDAO.findObjectById(id,Admin.class);
		
	}

	@Override
	public Customer getCustomer(Key id) {
		
		return (Customer) userDAO.findObjectById(id,Customer.class);
		
	}
	
}