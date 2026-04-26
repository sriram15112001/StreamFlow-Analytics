package com.streamflow.model;

import com.streamflow.enums.Status;

import java.time.LocalDate;

public class SalesInfo {
    private int salesId;
    private String customerId;
    private String customerName;
    private String category;
    private String product;
    private int quantity;
    private double unitPrice;
    private double amount;
    private LocalDate saleDate;
    private String region;
    private Status status;

    public SalesInfo() {
    }

    public SalesInfo(int salesId, String customerId, String customerName, String category, String product, int quantity, double unitPrice, double amount, LocalDate saleDate, String region, Status status) {
        this.salesId = salesId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.category = category;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.saleDate = saleDate;
        this.region = region;
        this.status = status;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SalesInfo{");
        sb.append("salesId=").append(salesId);
        sb.append(", customerId='").append(customerId).append('\'');
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", product='").append(product).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", amount=").append(amount);
        sb.append(", saleDate=").append(saleDate);
        sb.append(", region='").append(region).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
