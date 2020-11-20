package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "product_image", schema = "stormrider", catalog = "")
public class ProductImage {
    private int productImageId;
    private String image;
    private String name;
    private ProductGroup productGroupByProductGroupId;

    @Id
    @Column(name = "product_image_id", nullable = false)
    public int getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(int productImageId) {
        this.productImageId = productImageId;
    }

    @Basic
    @Column(name = "image", nullable = false, length = 256)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductImage that = (ProductImage) o;

        if (productImageId != that.productImageId) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productImageId;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "product_group_id", referencedColumnName = "product_group_id", nullable = false)
    public ProductGroup getProductGroupByProductGroupId() {
        return productGroupByProductGroupId;
    }

    public void setProductGroupByProductGroupId(ProductGroup productGroupByProductGroupId) {
        this.productGroupByProductGroupId = productGroupByProductGroupId;
    }
}
