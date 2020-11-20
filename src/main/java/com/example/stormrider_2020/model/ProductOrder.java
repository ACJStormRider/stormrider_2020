package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "product_order", schema = "stormrider", catalog = "")
public class ProductOrder {
    private int orderId;
    private String status;
    private Double costUnit;
    private Integer unitAmount;
    private Double taxPercentage;
    private Double shippingCost;
    private Date orderDate;
    private Date etaDate;
    private String comment;
    private String trackingNumber;
    private Product productByProductId;

    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "cost_unit", nullable = true, precision = 0)
    public Double getCostUnit() {
        return costUnit;
    }

    public void setCostUnit(Double costUnit) {
        this.costUnit = costUnit;
    }

    @Basic
    @Column(name = "unit_amount", nullable = true)
    public Integer getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(Integer unitAmount) {
        this.unitAmount = unitAmount;
    }

    @Basic
    @Column(name = "tax_percentage", nullable = true, precision = 0)
    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    @Basic
    @Column(name = "shipping_cost", nullable = true, precision = 0)
    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Basic
    @Column(name = "order_date", nullable = true)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "eta_date", nullable = true)
    public Date getEtaDate() {
        return etaDate;
    }

    public void setEtaDate(Date etaDate) {
        this.etaDate = etaDate;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = 255)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "tracking_number", nullable = true, length = 45)
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductOrder that = (ProductOrder) o;

        if (orderId != that.orderId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (costUnit != null ? !costUnit.equals(that.costUnit) : that.costUnit != null) return false;
        if (unitAmount != null ? !unitAmount.equals(that.unitAmount) : that.unitAmount != null) return false;
        if (taxPercentage != null ? !taxPercentage.equals(that.taxPercentage) : that.taxPercentage != null)
            return false;
        if (shippingCost != null ? !shippingCost.equals(that.shippingCost) : that.shippingCost != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (etaDate != null ? !etaDate.equals(that.etaDate) : that.etaDate != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (trackingNumber != null ? !trackingNumber.equals(that.trackingNumber) : that.trackingNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (costUnit != null ? costUnit.hashCode() : 0);
        result = 31 * result + (unitAmount != null ? unitAmount.hashCode() : 0);
        result = 31 * result + (taxPercentage != null ? taxPercentage.hashCode() : 0);
        result = 31 * result + (shippingCost != null ? shippingCost.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (etaDate != null ? etaDate.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (trackingNumber != null ? trackingNumber.hashCode() : 0);
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
}
