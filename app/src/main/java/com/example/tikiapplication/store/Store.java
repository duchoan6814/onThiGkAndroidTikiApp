package com.example.tikiapplication.store;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.tikiapplication.entity.Order;
import com.example.tikiapplication.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static Store instance = null;
    private List<Product> listProduct;
    private Order order;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Store() {
        listProduct = new ArrayList<>();
        order = new Order();
        addProductToList();
    }

    private void addProductToList() {
        this.listProduct.add(new Product(1, "Cáp chuyển từ Cổng \n" +
                "USB sang PS2...", 69000, 3, 15, 39));
        this.listProduct.add(new Product(2, "Ca nấu lẩu, nấu mì mini...", 150000, 1, 1, 44));
        this.listProduct.add(new Product(3, "1KG khô gà bơ tỏi...", 15000, 4, 20, 10));
        this.listProduct.add(new Product(4, "Xe cần cẩu đa năng", 50000, 4, 150, 30));
        this.listProduct.add(new Product(5, "Đồ chơi dạng mô hình", 79000, 1, 23, 0));
        this.listProduct.add(new Product(6, "Sách lãnh đạo giản đơn", 120000, 5, 120, 70));
        this.listProduct.add(new Product(7, "Hiểu lòng con trẻ", 60000, 3, 23, 33));
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Store getInstance(){
        if (instance == null){
            instance = new Store();
        }
        return instance;
    }
}
