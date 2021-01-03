package com.vr.shoppingcart.services;

import java.util.ArrayList;
import java.util.List;

import com.vr.shoppingcart.entity.Item;

import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Override
	public List<Item> getItems(long id) {		
		return new ArrayList<>();
	}

}
