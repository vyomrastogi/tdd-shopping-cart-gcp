package com.vr;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class ShoppingCartTest {

	/**
	 * Test to assert initial cart is empty
	 */
	@Test
	public void initialCartIsEmpty_test() {
		ShoppingCart shoppingCart = new ShoppingCart();
		assertFalse(shoppingCart.hasItems());
	}

	/**
	 * Test to assert when an item is added, cart is not empty
	 */
	@Test
	public void cartIsNotEmpty_WhenItemIsAdded_test() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Item item = new Item();
		shoppingCart.addItem(item);
		assertTrue(shoppingCart.hasItems());
	}

}
