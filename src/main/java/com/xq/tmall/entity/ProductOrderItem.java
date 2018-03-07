package com.xq.tmall.entity;

public class ProductOrderItem {
    private Integer productOrderItem_id;
    private Short productOrderItem_number;
    private Double productOrderItem_price;
    private Product productOrderItem_product;
    private ProductOrder productOrderItem_order;
    private User productOrderItem_user;

    public ProductOrderItem() {
    }

    public ProductOrderItem(Integer productOrderItem_id, Short productOrderItem_number, Double productOrderItem_price, Product productOrderItem_product, User productOrderItem_user) {
        this.productOrderItem_id = productOrderItem_id;
        this.productOrderItem_number = productOrderItem_number;
        this.productOrderItem_price = productOrderItem_price;
        this.productOrderItem_product = productOrderItem_product;
        this.productOrderItem_user = productOrderItem_user;
    }

    public ProductOrderItem(Integer productOrderItem_id, Short productOrderItem_number, Double productOrderItem_price, Product productOrderItem_product, ProductOrder productOrderItem_order, User productOrderItem_user) {
        this.productOrderItem_id = productOrderItem_id;
        this.productOrderItem_number = productOrderItem_number;
        this.productOrderItem_price = productOrderItem_price;
        this.productOrderItem_product = productOrderItem_product;
        this.productOrderItem_order = productOrderItem_order;
        this.productOrderItem_user = productOrderItem_user;
    }

    public Integer getProductOrderItem_id() {
        return productOrderItem_id;
    }

    public ProductOrderItem setProductOrderItem_id(Integer productOrderItem_id) {
        this.productOrderItem_id = productOrderItem_id;
        return this;
    }

    public Short getProductOrderItem_number() {
        return productOrderItem_number;
    }

    public ProductOrderItem setProductOrderItem_number(Short productOrderItem_number) {
        this.productOrderItem_number = productOrderItem_number;
        return this;
    }

    public Double getProductOrderItem_price() {
        return productOrderItem_price;
    }

    public ProductOrderItem setProductOrderItem_price(Double productOrderItem_price) {
        this.productOrderItem_price = productOrderItem_price;
        return this;
    }

    public Product getProductOrderItem_product() {
        return productOrderItem_product;
    }

    public ProductOrderItem setProductOrderItem_product(Product productOrderItem_product) {
        this.productOrderItem_product = productOrderItem_product;
        return this;
    }

    public ProductOrder getProductOrderItem_order() {
        return productOrderItem_order;
    }

    public ProductOrderItem setProductOrderItem_order(ProductOrder productOrderItem_order) {
        this.productOrderItem_order = productOrderItem_order;
        return this;
    }

    public User getProductOrderItem_user() {
        return productOrderItem_user;
    }

    public ProductOrderItem setProductOrderItem_user(User productOrderItem_user) {
        this.productOrderItem_user = productOrderItem_user;
        return this;
    }
}
