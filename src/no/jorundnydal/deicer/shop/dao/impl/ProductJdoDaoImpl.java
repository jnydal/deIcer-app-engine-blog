package no.jorundnydal.deicer.shop.dao.impl;

import no.jorundnydal.deicer.dao.impl.JdoDaoImpl;
import no.jorundnydal.deicer.shop.dao.ProductDAO;
import no.jorundnydal.deicer.shop.entity.Product;

import com.google.appengine.api.datastore.Key;
 
public class ProductJdoDaoImpl extends JdoDaoImpl<Product, Key> implements ProductDAO {



}