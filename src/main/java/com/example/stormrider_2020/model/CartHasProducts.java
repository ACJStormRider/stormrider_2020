package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart_has_products", schema = "stormrider_25112020", catalog = "")
public class CartHasProducts {
    private int cartHasProductId;
    private int productId;
    private int amount;
    private int cartId;

    @Id
    @Column(name = "cart_has_product_id", nullable = false)
    public int getCartHasProductId() {
        return cartHasProductId;
    }

    public void setCartHasProductId(int cartHasProductId) {
        this.cartHasProductId = cartHasProductId;
    }

    @Basic
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "cart_id", nullable = false)
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartHasProducts that = (CartHasProducts) o;
        return cartHasProductId == that.cartHasProductId &&
                productId == that.productId &&
                amount == that.amount &&
                cartId == that.cartId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartHasProductId, productId, amount, cartId);
    }
}
