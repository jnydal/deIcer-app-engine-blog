package no.jorundnydal.deicer.dao;
	 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import no.jorundnydal.deicer.entity.Page;

 
public interface GenericDao<T, ID extends Serializable> {
	
    public T saveObject(T object) ;
    
    public T saveObject(T object, Class clazz) ;

    public void deleteObject(T object);
    
    public void deleteObject(ID id);
 
    public T findObjectById(ID id);
    
    public T findObjectById(ID id, Class clazz);
    
    public List<T> findAll();

    public List<T> findAllDistinct();
    
    public Long count();
    
    public void flush();
    
    public boolean exists(ID id);

}