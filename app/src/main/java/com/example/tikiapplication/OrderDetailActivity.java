package com.example.tikiapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tikiapplication.entity.OrderDetail;
import com.example.tikiapplication.entity.Product;
import com.example.tikiapplication.store.Store;

public class OrderDetailActivity extends FragmentActivity implements CountQuatity.OnHandleCount {

    private Product product;
    private OrderDetail orderDetail;

    private TextView tvNameProduct;
    private TextView tvPriceDetail;
    private Button btnAddToCart;
    private FrameLayout flayoutCount;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        tvNameProduct = findViewById(R.id.tvNameProduct);
        tvPriceDetail = findViewById(R.id.tvPriceDetail);
        flayoutCount = findViewById(R.id.flayoutCount);

        btnAddToCart = findViewById(R.id.btnAddToCart);

        orderDetail = new OrderDetail();
        product = (Product) getIntent().getSerializableExtra("product");
        this.orderDetail.setNumberProduct(1);
        this.orderDetail.setProduct(product);

        tvNameProduct.setText(this.orderDetail.getProduct().getName());
        tvPriceDetail.setText("$"+this.orderDetail.tinhTongGiaTienOrderDetail());

        getSupportFragmentManager().beginTransaction().add(R.id.flayoutCount, CountQuatity.newInstance(this.orderDetail.getNumberProduct()), null).disallowAddToBackStack().commit();

        btnAddToCart.setOnClickListener(v -> handleOnClickAddToCart());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void handleOnClickAddToCart() {
        Intent intent = new Intent(this, OrderActivity.class);
        Store.getInstance().getOrder().getListOrderDetail().add(this.orderDetail);
        startActivity(intent);

    }

    @Override
    public void onClickButtonCount(int quatity) {
        this.orderDetail.setNumberProduct(quatity);
        tvPriceDetail.setText("$"+this.orderDetail.tinhTongGiaTienOrderDetail());
    }
}