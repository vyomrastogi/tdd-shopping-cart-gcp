package com.vr;

import java.util.Map.Entry;
import java.util.function.Predicate;

public class CartItem {
	
	private final String name;
	private final double price;
	private final int quantity;
	private final double totalPrice;
	private final boolean onSale;
	
	public CartItem(Entry<Item, Integer> cartEntry) {
		this.name = cartEntry.getKey().getName();
		this.price = cartEntry.getKey().getPrice();
		this.quantity = cartEntry.getValue();
		this.totalPrice = price*quantity;
		this.onSale = cartEntry.getKey().isOnSale();
	}
	
	public static Predicate<CartItem> isItem(Item item){
		return cartItem ->{			
			return cartItem.getName().equals(item.getName());
		};
	}

	private String getName() {
		return name;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public boolean isOnSale() {
		return onSale;
	}
}
