package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Product {
    private int productId;
    private short inventory;
    private Date lastUpdated;
    private Collection<CartHasProducts> cartHasProductsByProductId;
    private ProductGroup productGroupByProductGroupId;
    private Gender genderByGenderId;
    private Filling fillingByFillingId;
    private Color colorByColorId;
    private Size sizeBySizeId;
    private Collection<ProductOrder> productOrdersByProductId;
    private Collection<VoucherHasProduct> voucherHasProductsByProductId;

    @Id
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "inventory", nullable = false)
    public short getInventory() {
        return inventory;
    }

    public void setInventory(short inventory) {
        this.inventory = inventory;
    }

    @Basic
    @Column(name = "last_updated", nullable = false)
    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (inventory != product.inventory) return false;
        if (lastUpdated != null ? !lastUpdated.equals(product.lastUpdated) : product.lastUpdated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (int) inventory;
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<CartHasProducts> getCartHasProductsByProductId() {
        return cartHasProductsByProductId;
    }

    public void setCartHasProductsByProductId(Collection<CartHasProducts> cartHasProductsByProductId) {
        this.cartHasProductsByProductId = cartHasProductsByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "product_group_id", referencedColumnName = "product_group_id", nullable = false)
    public ProductGroup getProductGroupByProductGroupId() {
        return productGroupByProductGroupId;
    }

    public void setProductGroupByProductGroupId(ProductGroup productGroupByProductGroupId) {
        this.productGroupByProductGroupId = productGroupByProductGroupId;
    }

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "gender_id")
    public Gender getGenderByGenderId() {
        return genderByGenderId;
    }

    public void setGenderByGenderId(Gender genderByGenderId) {
        this.genderByGenderId = genderByGenderId;
    }

    @ManyToOne
    @JoinColumn(name = "filling_id", referencedColumnName = "filling_id")
    public Filling getFillingByFillingId() {
        return fillingByFillingId;
    }

    public void setFillingByFillingId(Filling fillingByFillingId) {
        this.fillingByFillingId = fillingByFillingId;
    }

    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "color_id")
    public Color getColorByColorId() {
        return colorByColorId;
    }

    public void setColorByColorId(Color colorByColorId) {
        this.colorByColorId = colorByColorId;
    }

    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "size_id")
    public Size getSizeBySizeId() {
        return sizeBySizeId;
    }

    public void setSizeBySizeId(Size sizeBySizeId) {
        this.sizeBySizeId = sizeBySizeId;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<ProductOrder> getProductOrdersByProductId() {
        return productOrdersByProductId;
    }

    public void setProductOrdersByProductId(Collection<ProductOrder> productOrdersByProductId) {
        this.productOrdersByProductId = productOrdersByProductId;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<VoucherHasProduct> getVoucherHasProductsByProductId() {
        return voucherHasProductsByProductId;
    }

    public void setVoucherHasProductsByProductId(Collection<VoucherHasProduct> voucherHasProductsByProductId) {
        this.voucherHasProductsByProductId = voucherHasProductsByProductId;
    }
}
