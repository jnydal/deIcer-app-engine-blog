package no.jorundnydal.deicer.dao.impl;


import java.util.List;

import javax.jdo.JDOException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.jdo.annotations.Cacheable;

import no.jorundnydal.deicer.dao.PostDAO;
import no.jorundnydal.deicer.entity.BlogPost;
import no.jorundnydal.deicer.entity.PageReference;

import org.springframework.orm.jdo.JdoCallback;
import org.springframework.transaction.annotation.Transactional;


 
public class PostJdoDaoImpl extends JdoDaoImpl<BlogPost, Long> implements PostDAO {

	
	@SuppressWarnings("unchecked")
	@Transactional
	@Cacheable(value = "findPosts")
	public List<BlogPost> findPosts(final String range) {
		
		List<BlogPost> result = null;
		
		try {
		
			result = (List<BlogPost>) this.getJdoTemplate().execute(new JdoCallback() {
	            public Object doInJdo(PersistenceManager pm) throws JDOException {
	            	
	            	 Query query = pm.newQuery();
	                 
	                 query.setClass(getPersistanceClass());
	                 
	                 query.setRange(range);
	                 
	                 query.setOrdering("date desc");
	                 
	                 List<BlogPost> list = (List<BlogPost>) query.execute();
	                 
	                 list.size(); //this is neccesarry to avoid object manager from closing due to default fetch plan - lazy loading
	                 
	                 query.close(list);
	                 
	                 return list;
	                
	            }
	            
	        });
		
		}catch (Exception e) {

			System.out.println("PostJdoDaoImpl: findPosts(): error: "+e.getMessage());
			
		}
		
		return result;
		
	}
	
}