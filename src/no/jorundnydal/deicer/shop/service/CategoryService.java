package no.jorundnydal.deicer.shop.service;

import no.jorundnydal.deicer.shop.entity.Category;
import no.jorundnydal.deicer.shop.entity.Product;

import com.google.appengine.api.datastore.Key;

public interface CategoryService {
	
	public Category getCategories(Key categorykey);
	
	public boolean addProduct(Key categorykey, Product product);
	
	public Category getRootCategory();
	
	public void storeCategory(Category category);
	
}
