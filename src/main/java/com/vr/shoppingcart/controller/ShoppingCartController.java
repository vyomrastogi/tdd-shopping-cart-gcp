package com.vr.shoppingcart.controller;

import java.util.List;

import com.vr.shoppingcart.entity.Item;
import com.vr.shoppingcart.services.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService cartService;

    @Get(uri = "/cart/{id}/items", processes = MediaType.APPLICATION_JSON)
    List<Item> getItems(long id) {
        return cartService.getItems(id);
    }
}
