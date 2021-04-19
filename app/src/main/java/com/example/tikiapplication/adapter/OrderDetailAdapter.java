package com.example.tikiapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tikiapplication.CountQuatity;
import com.example.tikiapplication.R;
import com.example.tikiapplication.entity.Order;
import com.example.tikiapplication.entity.OrderDetail;

import java.util.List;

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.ViewHolder> {
    private Context mContext;
    private List<OrderDetail> orderDetails;

    public OrderDetailAdapter(FragmentActivity context, List<OrderDetail> orderDetails) {
        this.mContext = context;
        this.orderDetails = orderDetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View orderDetailItemView = inflater.inflate(R.layout.order_detail_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(orderDetailItemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderDetail orderDetail = this.orderDetails.get(position);
        holder.tvItemOrderName.setText(orderDetail.getProduct().getName());
        holder.tvPrice.setText(orderDetail.tinhTongGiaTienOrderDetail()+"");
//        ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction().add(R.id.flayoutCountItem, CountQuatity.newInstance(orderDetail.getNumberProduct()), null).addToBackStack("name").commit();
//        ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction().add(R.id.flayoutCountItem, CountQuatity.newInstance(orderDetail.getNumberProduct())).disallowAddToBackStack().commit();
    }

    @Override
    public int getItemCount() {
        return this.orderDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItemOrderName;
        private TextView tvPrice;
        private FrameLayout flayoutCountItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemOrderName = itemView.findViewById(R.id.tvItemOrderName);
            tvPrice = itemView.findViewById(R.id.textView8);
            flayoutCountItem = itemView.findViewById(R.id.flayoutCountItem);

        }
    }
}
