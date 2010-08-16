package no.jorundnydal.deicer.shop.service;

import java.util.List;

import no.jorundnydal.deicer.shop.entity.Product;

import com.google.appengine.api.datastore.Key;

public interface ProductService {
	public List<Product> getProducts(Key categorykey);
}
