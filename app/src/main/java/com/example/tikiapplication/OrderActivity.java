package com.example.tikiapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tikiapplication.adapter.OrderDetailAdapter;
import com.example.tikiapplication.entity.Order;
import com.example.tikiapplication.entity.OrderDetail;
import com.example.tikiapplication.store.Store;

import java.util.List;

public class OrderActivity extends FragmentActivity {

    private RecyclerView recyclerView;
    private TextView tvSubtotal, tvTotal;

    private Order order;
    private OrderDetail orderDetail;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        recyclerView = findViewById(R.id.recyclerView);
        tvSubtotal = findViewById(R.id.tvSubtotal);
        tvTotal = findViewById(R.id.tvTotal);

        order = Store.getInstance().getOrder();

        OrderDetailAdapter orderDetailAdapter = new OrderDetailAdapter(this, order.getListOrderDetail());
        recyclerView.setAdapter(orderDetailAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}