package no.jorundnydal.deicer.dao.impl;


import java.util.List;

import javax.jdo.JDOException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.Cacheable;

import no.jorundnydal.deicer.dao.UserDAO;
import no.jorundnydal.deicer.entity.Admin;
import no.jorundnydal.deicer.entity.PageReference;
import no.jorundnydal.deicer.entity.User;

import org.springframework.orm.jdo.JdoCallback;
import org.springframework.transaction.annotation.Transactional;

import com.google.appengine.api.datastore.Key;
 

public class UserJdoDaoImpl extends JdoDaoImpl<User, Key> implements UserDAO {

	@SuppressWarnings("unchecked")
	@Transactional
	@Cacheable(value = "findAll")
	public List<Admin> findAllAdmins() {
        
		List<Admin> result = null;
		
		try {
		
			result = (List<Admin>) this.getJdoTemplate().execute(new JdoCallback() {
	            public Object doInJdo(PersistenceManager pm) throws JDOException {
	            	
	                Query query = pm.newQuery();
	                
	                query.setClass(Admin.class);
	                
	                List<Admin> list = (List<Admin>) query.execute();
	                
	                list.size(); //this is neccesarry to avoid object manager from closing due to default fetch plan - lazy loading
	                
	                query.close(list);
	                
	                return list;
	                
	            }
	            
	        });
		
		}catch (Exception e) {

			System.out.println("UserJdoDaoImpl: findAllAdmins(): error: "+e.getMessage());
			
		}
		
		return result;
		
	}

}