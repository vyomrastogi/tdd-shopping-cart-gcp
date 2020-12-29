package com.vr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class ShoppingCartTest {

	private ShoppingCart shoppingCart;

	@BeforeEach
	void init() {
		shoppingCart = new ShoppingCart();
	}

	/**
	 * Test to assert initial cart is empty
	 */
	@Test
	public void initialCartIsEmpty_test() {
		assertFalse(shoppingCart.hasItems());
	}

	/**
	 * Test to assert when an item is added, cart is not empty
	 */
	@Test
	public void cartIsNotEmpty_WhenItemIsAdded_test() {
		shoppingCart.addItem(Item.SHOES);
		assertTrue(shoppingCart.hasItems());
	}

	/**
	 * Test to assert total price of items in cart
	 */
	@Test
	public void totalPriceOfItemsInCart_test() {
		shoppingCart.addItem(Item.LAPTOP);
		assertEquals(Item.LAPTOP.getPrice(), shoppingCart.getTotalPrice());
		shoppingCart.addItem(Item.SHOES);
		double expectedPrice = Item.LAPTOP.getPrice() + Item.SHOES.getPrice();
		assertEquals(expectedPrice, shoppingCart.getTotalPrice());
	}

	/**
	 * Test to assert that quantity of item is updated in cart
	 */
	@Test
	public void quantityOfItemsInCart_WhenMoreAreAdded_test() {
		shoppingCart.addItem(Item.PERFUME);
		assertEquals(1, shoppingCart.getQuantity(Item.PERFUME));
		shoppingCart.addItem(Item.PERFUME);
		assertEquals(2, shoppingCart.getQuantity(Item.PERFUME));
	}

	/**
	 * Test to assert itemized list has quantity and price of each item
	 */
	@Test
	public void getItemizedList_test() {
		shoppingCart.addItem(Item.BABRA_ELITE);
		shoppingCart.addItem(Item.BABRA_ELITE);
		shoppingCart.addItem(Item.LAPTOP);
		shoppingCart.addItem(Item.WALLET);

		Set<CartItem> actualList = shoppingCart.getCartItem();
		assertNotNull(actualList);

		double expectedBabraElitePrice = Item.BABRA_ELITE.getPrice() * 2;
		assertEquals(expectedBabraElitePrice, getPriceOfItemFromList(actualList, Item.BABRA_ELITE));
	}

	private double getPriceOfItemFromList(Set<CartItem> cartItems, Item item) {
		return cartItems.stream().filter(CartItem.isItem(item))
				.findFirst()
				.map(CartItem::getTotalPrice)
				.orElseGet(() -> 0.0);
	}
}
