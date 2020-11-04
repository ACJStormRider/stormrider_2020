package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long>
{
    List<Cart> getCartByCartId(int cartId);
}
