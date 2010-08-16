package no.jorundnydal.deicer.shop.entity;

import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Category
{
	
@Persistent
@Extension(vendorName="datanucleus", key="gae.parent-pk", value="true")
 private Key parent;
 
@Persistent
private List<Key> subcategories;

@Persistent
private List<Key> products;

@Persistent
private String title;

@Persistent
private String description;

@PrimaryKey
@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
private Key id;

 private boolean isRoot;

public List<Key> getProducts() {
	return products;
}

public void setProducts(List<Key> products) {
	this.products = products;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Key getId() {
	return id;
}

public void setId(Key id) {
	this.id = id;
}

public void setRoot(boolean isRoot) {
	this.isRoot = isRoot;
}

public boolean isRoot() {
	return isRoot;
}

public void setParent(Key parent) {
	this.parent = parent;
}

public Key getParent() {
	return parent;
}

public void setSubcategories(List<Key> subcategories) {
	this.subcategories = subcategories;
}

public List<Key> getSubcategories() {
	return subcategories;
}

}
