package no.jorundnydal.deicer.shop.entity;

import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import no.jorundnydal.deicer.entity.DownloadableFile;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Product {

 public Product(String title, String description, Long price, Date releasedate) {
  this.title = title;
  this.description = description;
  this.price = price;
  this.releasedate = releasedate;
 }

public Product() {
	// TODO Auto-generated constructor stub
}

@PrimaryKey
 @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
 private Key id;
 
@Persistent
private String imageId;

@Persistent
@Extension(vendorName="datanucleus", key="gae.parent-pk", value="true")
private Key categorykey;

@Persistent
private Long price;

@Persistent
private Date releasedate;

@Persistent
private String title;

 @Persistent
 private Long stock;

 @Persistent
 private String description;

 public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Long getStock() {
	return stock;
}

public void setStock(Long stock) {
	this.stock = stock;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Long getPrice() {
	return price;
}

public void setPrice(Long price) {
	this.price = price;
}

public Date getReleasedate() {
	return releasedate;
}

public void setReleasedate(Date releasedate) {
	this.releasedate = releasedate;
}

public void setImageId(String imageId) {
	this.imageId = imageId;
}

public String getImageId() {
	return imageId;
}

public void setId(Key id) {
	this.id = id;
}

public Key getId() {
	return id;
}

public void setCategory(Key categorykey) {
	this.categorykey = categorykey;
}

public Key getCategory() {
	return categorykey;
}

}
