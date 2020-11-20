package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "cart_has_products", schema = "stormrider", catalog = "")
public class CartHasProducts {
    private int cartHasProductId;
    private int amount;
    private Product productByProductId;
    private Cart cartByCartId;

    @Id
    @Column(name = "cart_has_product_id", nullable = false)
    public int getCartHasProductId() {
        return cartHasProductId;
    }

    public void setCartHasProductId(int cartHasProductId) {
        this.cartHasProductId = cartHasProductId;
    }

    @Basic
    @Column(name = "amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartHasProducts that = (CartHasProducts) o;

        if (cartHasProductId != that.cartHasProductId) return false;
        if (amount != that.amount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartHasProductId;
        result = 31 * result + amount;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id", nullable = false)
    public Cart getCartByCartId() {
        return cartByCartId;
    }

    public void setCartByCartId(Cart cartByCartId) {
        this.cartByCartId = cartByCartId;
    }
}
