package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.Cart;
import com.example.stormrider_2020.repository.CartRepository;
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


    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> getAllCart(){
         try{
            List<Cart> carts = new ArrayList<>();
            carts = cartRepository.findAll();

            if(carts.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
                return new ResponseEntity<>(HttpStatus.OK);
         } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }


    @GetMapping("/cart{id}")
    public ResponseEntity<Cart> getCartById(long id){
        Optional<Cart> cartData = cartRepository.findById(id);
        if (cartData.isPresent())
            return new ResponseEntity<>(cartData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/cart")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        try {
            Cart cart1 = cartRepository.save(cart);
            return new ResponseEntity<>(cart1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/cart_id{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable("id") long id, @RequestBody Cart cart){
        Optional<Cart> cartData = cartRepository.findById(id);

        if (cartData.isPresent()){
            Cart cart1 = cartData.get();
            cart1.setStatus(cart.getStatus());
            cart1.setTotalPrice(cart.getTotalPrice());
            cart1.setVat(cart.getVat());
            cart1.setTotalDiscount(cart.getTotalDiscount());
            cart1.setCreated(cart.getCreated());
            cart1.setVoucherId(cart.getVoucherId());
            cart1.setTrackingNumber(cart.getTrackingNumber());
            //cart1.setAddressByBillingAddressId(cart.getAddressByBillingAddressId());
            //cart1.setAddressByShippingAddressId(cart.getAddressByShippingAddressId());
            //cart1.setCustomerByCustomerId(cart.getCustomerByCustomerId());
            return new ResponseEntity<>(cartRepository.save(cart1), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/cart_id{id}")
    public ResponseEntity<HttpStatus> deleteCart(@PathVariable("id") long id){
        try {
            cartRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
