package no.jorundnydal.deicer.shop;

import java.util.List;

public class ShoppingCart 
	{
	
	List<ShoppingCartItem> items;
	
	public boolean removeItem(ShoppingCartItem item) 
	{
		return items.remove(item);
	}
	public boolean addItem(ShoppingCartItem item) 
	{
		return items.add(item);
	}
	public void setAmount(ShoppingCartItem item, int amount)
	{
		int itemPos = items.indexOf(item);
		ShoppingCartItem cartItem = items.get(itemPos);
		cartItem.setQuantity(amount);
	}
}
