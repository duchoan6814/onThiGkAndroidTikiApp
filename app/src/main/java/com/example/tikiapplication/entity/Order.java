package com.example.tikiapplication.entity;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private LocalDateTime orderDate;
    private List<OrderDetail> listOrderDetail;

    @Override
    public String toString() {
        return "Order{" +
                "orderDate=" + orderDate +
                ", listOrderDetail=" + listOrderDetail +
                '}';
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetail> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Order() {
        this.orderDate = LocalDateTime.now();
        this.listOrderDetail = new ArrayList<>();
    }

    public Order(LocalDateTime orderDate, List<OrderDetail> listOrderDetail) {
        this.orderDate = orderDate;
        this.listOrderDetail = listOrderDetail;
    }
}
