package com.vr.shoppingcart.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.vr.shoppingcart.entity.Item;
import com.vr.shoppingcart.services.ShoppingCartService;
import com.vr.shoppingcart.services.ShoppingCartServiceImpl;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;


@MicronautTest
public class ShoppingCartCollaboratorTest {

	@Inject
	ShoppingCartService cartService;
	
	@Inject
	@Client("/")
	RxHttpClient client;
	
	@ParameterizedTest
	@ValueSource(longs = {1})
	void testCartIsEmpty(long id) {
		when(cartService.getItems(id)).thenReturn(new ArrayList<>());
		List<Item> result = client.toBlocking().retrieve(HttpRequest.GET("/cart/1/items"),List.class);
		assertNotNull(result);
		assertEquals(0, result.size());
	}
	
	@MockBean(ShoppingCartServiceImpl.class)
	ShoppingCartService cartService() {
		return mock(ShoppingCartService.class);
	}

}
