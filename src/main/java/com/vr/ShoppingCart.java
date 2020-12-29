package com.vr;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCart {

	private final Map<Item, Integer> cartItems = new HashMap<>();

	/**
	 * @return true, if cart has items
	 */
	public boolean hasItems() {
		return !cartItems.isEmpty();
	}

	public void addItem(Item item) {
		cartItems.merge(item, 1, (existing, unit) -> existing + unit);
	}

	/**
	 * @return total price of items in cart
	 */
	public double getTotalPrice() {
		return cartItems.entrySet().parallelStream().collect(Collectors.summingDouble(e -> e.getKey().getPrice()));
	}

	public int getQuantity(Item item) {
		return cartItems.getOrDefault(item, 0);
	}

}
