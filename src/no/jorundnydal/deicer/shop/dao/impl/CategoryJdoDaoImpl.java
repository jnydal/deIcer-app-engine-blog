package no.jorundnydal.deicer.shop.dao.impl;

import java.util.List;

import javax.jdo.JDOException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import no.jorundnydal.deicer.dao.impl.JdoDaoImpl;
import no.jorundnydal.deicer.shop.dao.CategoryDAO;
import no.jorundnydal.deicer.shop.entity.Category;

import org.springframework.orm.jdo.JdoCallback;

import com.google.appengine.api.datastore.Key;

 
public class CategoryJdoDaoImpl extends JdoDaoImpl<Category, Key> implements CategoryDAO {

	@SuppressWarnings("unchecked")
	public List<Key> getProducts(final Key categorykey) {
    	
		List<Key> result = null;
		
		try {
		
			result = (List<Key>) this.getJdoTemplate().execute(new JdoCallback() {
	            public Object doInJdo(PersistenceManager pm) throws JDOException {
	            	
	                Query query = pm.newQuery(categorykey);
	                
	                query.setClass(getPersistanceClass());
	                
	                List<Category> list = (List<Category>) query.execute();
	                
	                list.size(); //this is neccesarry to avoid object manager from closing due to default fetch plan - lazy loading
	                
	                Category category = list.get(0);
	                
	                query.close(list);
	                
	                return category.getProducts();
	                
	            }
	            
	        });
		
		}catch (Exception e) {

			System.out.println("CategoryjdoDaoImpl: getProducts(): error: "+e.getMessage());
			
		}
		
		return result;
		
	}

	@Override
	public Category getRoot() {
		
		return null;
		
	}

	@Override
	public Category storeCategory(Category category) {
    	
		Category result = null;
		
		try {
			
			if (count()==0) {
	    		
	    		System.out.println("found no entities in datastore");
	    		category.setRoot(true);
	    		
	    	}
	    	
	    	result = getJdoTemplate().makePersistent(category);
			
		}catch (Exception e) {

			System.out.println("CategoryJdoDaoImpl: storeCategory(category): error: "+e.getMessage());
			
		}
		
		return result;
		
	}

}