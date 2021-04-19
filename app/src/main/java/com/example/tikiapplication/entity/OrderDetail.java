package com.example.tikiapplication.entity;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private Product product;
    private int numberProduct;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "product=" + product +
                ", numberProduct=" + numberProduct +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumberProduct() {
        return numberProduct;
    }

    public void setNumberProduct(int numberProduct) {
        this.numberProduct = numberProduct;
    }

    public OrderDetail() {
    }

    public OrderDetail(Product product, int numberProduct) {
        this.product = product;
        this.numberProduct = numberProduct;
    }

    public double tinhTongGiaTienOrderDetail(){
        return this.product.getPrice() * this.numberProduct;
    }
}
