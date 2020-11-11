package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.Cart;
import com.example.stormrider_2020.repository.CartRepository;
import com.example.stormrider_2020.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CartController
{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartService cartService;


    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> getAllCart(@RequestParam(required = false) int cartId)
    {
        return cartService.getAll(cartId);
    }


    @GetMapping("/cart{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id") long id)
    {
        return cartService.getById(id);
    }

    // see notes in service please
    @PostMapping("/cart_id{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable("id") long id, @RequestBody Cart cart)
    {
        return cartService.update(id, cart);
    }


    @DeleteMapping("/cart_id{id}")
    public ResponseEntity<HttpStatus> deleteCart(@PathVariable("id") long id)
    {
        return cartService.delete(id);
    }


}
