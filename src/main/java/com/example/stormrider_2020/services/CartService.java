package com.example.stormrider_2020.services;

import com.example.stormrider_2020.model.Cart;
import com.example.stormrider_2020.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService
{
    @Autowired
    CartRepository cartRepository;


    public ResponseEntity<List<Cart>> getAll(int cartId)
    {
        return getAllCart(cartId);
    }



    }


    public ResponseEntity<Cart> getById(long id)
    {
        Optional<Cart> cartData = cartRepository.findById(id);
        if(cartData.isPresent())
            return new ResponseEntity<>(cartData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Cart> update(long id, Cart cart)
    {
        Optional<Cart> cartData = cartRepository.findById(id);

        // is customer identified during this process?

        if (cartData.isPresent())
        {
            Cart cart1 = cartData.get();
            cart1.setStatus(cart.getStatus());
            cart1.setVat(cart.getVat());
            cart1.setTotalDiscount(cart.getTotalDiscount());
            cart1.setTotalPrice(cart.getTotalPrice());
            // not sure voucher,cust, ship + bill id should be here - cust cant set this?? - leave for placeholder
            cart1.setVoucherId(cart.getVoucherId());
            cart1.setCustomerId(cart.getCustomerId());
            cart1.setBillingAddressId(cart.getBillingAddressId());
            cart1.setShippingAddressId(cart.getShippingAddressId());

            return new ResponseEntity<>(cartRepository.save(cart1), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<HttpStatus> delete(long id)
    {
        try
        {
            cartRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
