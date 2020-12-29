package com.vr;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private final List<Item> cartItems = new ArrayList<>();

	public boolean hasItems() {
		return !cartItems.isEmpty();
	}

	public void addItem(Item item) {
		cartItems.add(item);
	}

}
