package com.vr;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		assertEquals(0,shoppingCart.getItems());
	}

}
