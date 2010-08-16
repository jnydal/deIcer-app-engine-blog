package no.jorundnydal.deicer.service;

import java.util.List;

import no.jorundnydal.deicer.entity.Admin;
import no.jorundnydal.deicer.entity.User;
import no.jorundnydal.deicer.shop.entity.Customer;

import com.google.appengine.api.datastore.Key;

public interface UserService {

	public Admin storeAdmin(Admin admin);
	
	public Customer storeCustomer(Customer u);
	
	public List<User> getAllUsers();
	
	public List<Admin> getAllAdmins();
	
	public Admin getAdmin(Key id);
	
	public Customer getCustomer(Key id);
	
}
