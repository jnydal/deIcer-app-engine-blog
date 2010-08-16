package no.jorundnydal.deicer.dao.impl;
 
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jdo.JDOException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.jdo.annotations.Cacheable;

import no.jorundnydal.deicer.Domain;
import no.jorundnydal.deicer.PMF;
import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.dao.GenericDao;
import no.jorundnydal.deicer.entity.BlogPost;
import no.jorundnydal.deicer.entity.Page;

import org.springframework.orm.jdo.JdoCallback;
import org.springframework.orm.jdo.JdoTemplate;
import org.springframework.orm.jdo.support.JdoDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.google.appengine.api.datastore.Text;


public abstract class JdoDaoImpl<T, ID extends Serializable> extends JdoDaoSupport implements GenericDao<T, ID> {
	
	Class persistanceClass;
	
	Domain nifrostBeanReference;

	public JdoDaoImpl() {
		
		this.setPersistenceManagerFactory(PMF.get());
		
	}
	
	public void deleteObject(T object) {
		
		getJdoTemplate().deletePersistent(object);
		
	}
	
	public void deleteObject(ID id) {
		
        PersistenceManager pm = getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        try {
			tx.begin();
			
			@SuppressWarnings("unchecked")
			T object = (T) pm.getObjectById(getPersistanceClass(),id);
			pm.deletePersistent(object);
			
			tx.commit();
        } finally {
        	
            if (tx.isActive()) {
                tx.rollback();
            }
            
        }
		
	}
 
	@SuppressWarnings("unchecked")
	@Transactional
	@Cacheable(value = "findAll")
	public List<T> findAll() {
		
		List<T> result = null;
		
		try {
		
			result = (List<T>) this.getJdoTemplate().execute(new JdoCallback() {
	            public Object doInJdo(PersistenceManager pm) throws JDOException {
	            	
	            	Query query = pm.newQuery();
	                
	                query.setClass(getPersistanceClass());
	                
	                List<T> result = (List<T>) query.execute();
	                
	                result.size(); //this is neccesarry to avoid object manager from closing due to default fetch plan - lazy loading
	
	                query.close(result);
	                
	                return result;
	                
	            }
	            
	        });
		
		}catch (Exception e) {

			System.out.println("jdoDaoImpl: findAll(): error: "+e.getMessage());
			
		}
		
		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	public T saveObject(T object, Class clazz) {
		
		T result = null;
		
		try {
			
			result = (T) getJdoTemplate().makePersistent(clazz.cast(object));
			
		}catch (Exception e) {

			System.out.println("jdoDaoImpl: saveObject(object,class): error: "+e.getMessage());
			
		}
		
		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	public Long count() {
		
		Long result = null;
		
		try {
		
			result = ((Integer) this.getJdoTemplate().execute(new JdoCallback() {
	            public Object doInJdo(PersistenceManager pm) throws JDOException {
	            	
	    			Query q = pm.newQuery(getPersistanceClass());
	    		    q.setResult("count(this)");
	    		    Integer count = (Integer) q.execute();
	    		    q.close(count);
					return count;
	                
	            }
	        })).longValue();
		
		}catch (Exception e) {

			System.out.println("jdoDaoImpl: count(): error: "+e.getMessage());
			
		}
		
		return result;

	}
	
	@Transactional
	public T saveObject(T object) {
		
		T result = null;
		
		try {
			
			result = (T) getJdoTemplate().makePersistent(object);
			
		}catch (Exception e) {

			System.out.println("jdoDaoImpl: saveObject(object): error: "+e.getMessage());
			
		}
		
		return result;
		
	}
 
	@SuppressWarnings("unchecked")
	@Cacheable(value = "findObjectById")
	public T findObjectById(final ID id) {
		
		T result = null;
		
		try {
		
			result = (T) this.getJdoTemplate().execute(new JdoCallback() {
	            public Object doInJdo(PersistenceManager pm) throws JDOException {
	            	
	            	Query query = pm.newQuery();

	                T object = (T) pm.getObjectById(getPersistanceClass(), id);
	                
	                query.close(object);
	                
	                return object;
	                
	            }
	            
	        });
		
		}catch (Exception e) {

			System.out.println("jdoDaoImpl: findAll(): error: "+e.getMessage());
			
		}
		
		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	public T findObjectById(final ID id, final Class clazz) {
		
		T result = null;
		
		try {
		
			result = (T) this.getJdoTemplate().execute(new JdoCallback() {
	            public Object doInJdo(PersistenceManager pm) throws JDOException {
	            	
	            	Query query = pm.newQuery();

	                T object = (T) pm.getObjectById(clazz, id);
	                
	                query.close(object);
	                
	                return object;
	                
	            }
	            
	        });
		
		}catch (Exception e) {

			System.out.println("jdoDaoImpl: findAll(): error: "+e.getMessage());
			
		}
		
		return result;
		
	}
	
	public void flush() {
		
		getJdoTemplate().flush();
	
	}
	
	@SuppressWarnings("unchecked")
	protected Class getPersistanceClass()
	{
		if (persistanceClass == null)
			persistanceClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
 
		return persistanceClass;
	}
	
	@Override
	public boolean exists(ID id) {
		
		return false;
		
	}
	
	@Override
	public List<T> findAllDistinct() {
		
		return null;
		
	}
 
}