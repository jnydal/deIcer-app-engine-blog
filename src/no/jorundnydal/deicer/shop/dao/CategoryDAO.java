package no.jorundnydal.deicer.shop.dao;


import java.util.List;

import no.jorundnydal.deicer.dao.GenericDao;
import no.jorundnydal.deicer.shop.entity.Category;
import no.jorundnydal.deicer.shop.entity.Product;

import com.google.appengine.api.datastore.Key;


public interface CategoryDAO extends GenericDao<Category, Key> {
 
	public List<Key> getProducts(Key categorykey);
	
	public Category getRoot();
	
	public Category storeCategory(Category category);
 
}