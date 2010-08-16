package no.jorundnydal.deicer.shop.dao;

import no.jorundnydal.deicer.dao.GenericDao;
import no.jorundnydal.deicer.shop.entity.Product;

import com.google.appengine.api.datastore.Key;

public interface ProductDAO  extends GenericDao<Product, Key>{

}
