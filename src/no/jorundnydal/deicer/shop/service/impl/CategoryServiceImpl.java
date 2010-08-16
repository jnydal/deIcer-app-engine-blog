package no.jorundnydal.deicer.shop.service.impl;

import no.jorundnydal.deicer.shop.dao.CategoryDAO;
import no.jorundnydal.deicer.shop.entity.Category;
import no.jorundnydal.deicer.shop.entity.Product;
import no.jorundnydal.deicer.shop.service.CategoryService;

import com.google.appengine.api.datastore.Key;

public class CategoryServiceImpl implements CategoryService{

	private CategoryDAO categoryDAO;
	
	@Override
	public Category getCategories(Key categorykey) {
		return categoryDAO.findObjectById(categorykey);
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	@Override
	public boolean addProduct(Key categorykey, Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category getRootCategory() {
		return categoryDAO.getRoot();
	}

	@Override
	public void storeCategory(Category category) {

		categoryDAO.storeCategory(category);
		
	}

}
