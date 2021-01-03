package com.vr.shoppingcart.services;

import java.util.List;

import com.vr.shoppingcart.entity.Item;

public interface ShoppingCartService {

	public List<Item> getItems(long id);
}
