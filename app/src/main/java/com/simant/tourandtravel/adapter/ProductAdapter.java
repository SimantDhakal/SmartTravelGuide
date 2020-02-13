package com.simant.tourandtravel.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.simant.tourandtravel.R;
import com.simant.tourandtravel.activity.DetailSubCategoryActivity;
import com.simant.tourandtravel.activity.ReviewActivity;
import com.simant.tourandtravel.modal.ProductModal;

import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{

    Context context;
    List<ProductModal> teamModalClasses;

    public ProductAdapter(Context context, List<ProductModal> teamModalClasses) {
        this.context = context;
        this.teamModalClasses = teamModalClasses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //// getting data according to position
        final ProductModal ProductModal = teamModalClasses.get(position);

        holder.textView_menu.setText(ProductModal.get_productName());
        holder.textView_price.setText("NRP. " +ProductModal.get_productPrice());
//        holder.textView_desc.setText(ProductModal.get_productPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReviewActivity.id = ProductModal.get_id();
                Intent intent = new Intent(context, ReviewActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teamModalClasses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView_menu, textView_price, textView_desc;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView_menu = itemView.findViewById(R.id.specialMenu);
            textView_price = itemView.findViewById(R.id.specialPrice);
//            textView_desc = itemView.findViewById(R.id.specialDesc);
        }
    }
}