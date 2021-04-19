package com.example.tikiapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.tikiapplication.adapter.ProductAdapter;
import com.example.tikiapplication.entity.Product;
import com.example.tikiapplication.store.Store;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductAdapter.OnActionProductItem {
    private RecyclerView recyclerView;
    private List<Product> listProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcvMain);

        listProduct = Store.getInstance().getListProduct();

        ProductAdapter productAdapter = new ProductAdapter(this, listProduct, this);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

    @Override
    public void onClickItem(int prosition) {
        Product product = this.listProduct.get(prosition);
        Intent intent = new Intent(this, OrderDetailActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }
}