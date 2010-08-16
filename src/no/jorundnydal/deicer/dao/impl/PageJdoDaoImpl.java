package no.jorundnydal.deicer.dao.impl;

import java.util.List;

import javax.jdo.JDOException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.Cacheable;

import no.jorundnydal.deicer.dao.PageDAO;
import no.jorundnydal.deicer.entity.Admin;
import no.jorundnydal.deicer.entity.Page;
import no.jorundnydal.deicer.entity.PageReference;

import org.springframework.orm.jdo.JdoCallback;

 
public class PageJdoDaoImpl extends JdoDaoImpl<Page, Long> implements PageDAO {

	@SuppressWarnings("unchecked")
	@Cacheable(value = "getPageReferences")
	public List<PageReference> getPageReferences() {
        
		List<PageReference> result = null;
		
		try {
		
			result = (List<PageReference>) this.getJdoTemplate().execute(new JdoCallback() {
	            public Object doInJdo(PersistenceManager pm) throws JDOException {
	            	
	                Query q = pm.newQuery(getPersistanceClass());
	                q.setResultClass(PageReference.class);
	                List<PageReference> list = (List<PageReference>)q.execute ();
	                
	                list.size(); //this is neccesarry to avoid object manager from closing due to default fetch plan - lazy loading
	                
	                q.close(list);
	                
	                return list;
	                
	            }
	            
	        });
		
		}catch (Exception e) {

			System.out.println("PageJdoDaoImpl: getPagereferences(): error: "+e.getMessage());
			
		}
		
		return result;
	
	}

}