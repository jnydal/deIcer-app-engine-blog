package no.jorundnydal.deicer.shop.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import no.jorundnydal.deicer.shop.dao.CategoryDAO;
import no.jorundnydal.deicer.shop.dao.ProductDAO;
import no.jorundnydal.deicer.shop.entity.Product;
import no.jorundnydal.deicer.shop.service.ProductService;

import com.google.appengine.api.datastore.Key;

public class ProductServiceImpl implements ProductService{

	private ProductDAO productDAO;
	private CategoryDAO categoryDAO;
	
	@Override
	public List<Product> getProducts(Key categorykey) {
		
		List<Key> productKeys = categoryDAO.getProducts(categorykey);
		
		List<Product> products = new ArrayList<Product>();

		for (Iterator iter = productKeys.iterator(); iter.hasNext();) {
		   Key p = (Key) iter.next();
		   Product product = productDAO.findObjectById(p);
		   products.add(product);
		}
		
		return products;
		
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

}
