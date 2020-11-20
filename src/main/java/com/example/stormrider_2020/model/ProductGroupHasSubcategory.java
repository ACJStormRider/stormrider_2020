package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "product_group_has_subcategory", schema = "stormrider", catalog = "")
@IdClass(ProductGroupHasSubcategoryPK.class)
public class ProductGroupHasSubcategory {
    private int productGroupId;
    private int subcategoryId;
    private ProductGroup productGroupByProductGroupId;
    private Subcategory subcategoryBySubcategoryId;

    @Id
    @Column(name = "product_group_id", nullable = false)
    public int getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(int productGroupId) {
        this.productGroupId = productGroupId;
    }

    @Id
    @Column(name = "subcategory_id", nullable = false)
    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductGroupHasSubcategory that = (ProductGroupHasSubcategory) o;

        if (productGroupId != that.productGroupId) return false;
        if (subcategoryId != that.subcategoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productGroupId;
        result = 31 * result + subcategoryId;
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

    @ManyToOne
    @JoinColumn(name = "subcategory_id", referencedColumnName = "sub_category_id", nullable = false)
    public Subcategory getSubcategoryBySubcategoryId() {
        return subcategoryBySubcategoryId;
    }

    public void setSubcategoryBySubcategoryId(Subcategory subcategoryBySubcategoryId) {
        this.subcategoryBySubcategoryId = subcategoryBySubcategoryId;
    }
}
