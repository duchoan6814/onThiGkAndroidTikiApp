package com.example.tikiapplication.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private double price;
    private int rateStar;
    private int numberPeopleRate;
    private double discount;

    public Product(int id, String name, double price, int rateStar, int numberPeopleRate, double discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rateStar = rateStar;
        this.numberPeopleRate = numberPeopleRate;
        this.discount = discount;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRateStar() {
        return rateStar;
    }

    public void setRateStar(int rateStar) {
        this.rateStar = rateStar;
    }

    public int getNumberPeopleRate() {
        return numberPeopleRate;
    }

    public void setNumberPeopleRate(int numberPeopleRate) {
        this.numberPeopleRate = numberPeopleRate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rateStar=" + rateStar +
                ", numberPeopleRate=" + numberPeopleRate +
                ", discount=" + discount +
                '}';
    }
}
