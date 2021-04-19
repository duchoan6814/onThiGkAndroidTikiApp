package com.example.tikiapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tikiapplication.R;
import com.example.tikiapplication.entity.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> listProduct;
    private Context context;
    private OnActionProductItem onActionProductItem;

    public ProductAdapter(Context context, List<Product> listProduct, OnActionProductItem onActionProductItem) {
        this.context = context;
        this.listProduct = listProduct;
        this.onActionProductItem = onActionProductItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View productView = inflater.inflate(R.layout.shop_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(productView, this.onActionProductItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = this.listProduct.get(position);
        holder.tvName.setText(product.getName());
        holder.rtbRateStart.setRating(product.getRateStar());
        holder.tvNumberRating.setText("("+product.getNumberPeopleRate()+")");
        holder.tvPrice.setText("$"+product.getPrice());
        holder.tvDiscount.setText(("-"+product.getDiscount()+"%"));
    }

    @Override
    public int getItemCount() {
        return this.listProduct.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvName;
        private RatingBar rtbRateStart;
        private TextView tvNumberRating;
        private TextView tvPrice;
        private TextView tvDiscount;
        private OnActionProductItem onActionProductItem;
        public ViewHolder(@NonNull View itemView, OnActionProductItem onActionProductItem) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvNameItem);
            rtbRateStart = itemView.findViewById(R.id.ratingBar);
            tvNumberRating = itemView.findViewById(R.id.tvNumberPeopleRate);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvDiscount = itemView.findViewById(R.id.tvDiscount);

            this.onActionProductItem = onActionProductItem;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.onActionProductItem.onClickItem(getAdapterPosition());
        }
    }

    public interface OnActionProductItem {
        void onClickItem(int prosition);
    }
}
