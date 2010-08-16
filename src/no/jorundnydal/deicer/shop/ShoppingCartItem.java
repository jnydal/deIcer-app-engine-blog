package no.jorundnydal.deicer.shop;

import no.jorundnydal.deicer.shop.entity.Product;

public class ShoppingCartItem {
	
	Product product;
	
	int amount;
	
	public void setQuantity(int amount) 
	{
		this.amount = amount;
	}
}
