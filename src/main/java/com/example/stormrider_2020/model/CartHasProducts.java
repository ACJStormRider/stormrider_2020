package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "cart_has_products", schema = "stormrider", catalog = "")
public class CartHasProducts {
    private int cartHasProductId;
    private int productId;
    private int amount;
    private int cartId;

    @Id
    @Column(name = "cart_has_product_id")
    public int getCartHasProductId() {
        return cartHasProductId;
    }

    public void setCartHasProductId(int cartHasProductId) {
        this.cartHasProductId = cartHasProductId;
    }

    @Basic
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "cart_id")
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

        if (cartHasProductId != that.cartHasProductId) return false;
        if (productId != that.productId) return false;
        if (amount != that.amount) return false;
        if (cartId != that.cartId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartHasProductId;
        result = 31 * result + productId;
        result = 31 * result + amount;
        result = 31 * result + cartId;
        return result;
    }
}
