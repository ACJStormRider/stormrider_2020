package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "product_order", schema = "stormrider_25112020", catalog = "")
public class ProductOrder {
    private int orderId;
    private String status;
    private int productId;
    private Double costUnit;
    private Integer unitAmount;
    private Double taxPercentage;
    private Double shippingCost;
    private Date orderDate;
    private Date etaDate;
    private String comment;
    private String trackingNumber;

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
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        return orderId == that.orderId &&
                productId == that.productId &&
                Objects.equals(status, that.status) &&
                Objects.equals(costUnit, that.costUnit) &&
                Objects.equals(unitAmount, that.unitAmount) &&
                Objects.equals(taxPercentage, that.taxPercentage) &&
                Objects.equals(shippingCost, that.shippingCost) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(etaDate, that.etaDate) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(trackingNumber, that.trackingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, status, productId, costUnit, unitAmount, taxPercentage, shippingCost, orderDate, etaDate, comment, trackingNumber);
    }
}
