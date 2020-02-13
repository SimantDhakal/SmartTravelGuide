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
import com.simant.tourandtravel.activity.SubCategoryActivity;
import com.simant.tourandtravel.modal.CategoryModal;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>{

    Context context;
    List<CategoryModal> teamModalClasses;

    public CategoryAdapter(Context context, List<CategoryModal> teamModalClasses) {
        this.context = context;
        this.teamModalClasses = teamModalClasses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_category,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //// getting data according to position
        final CategoryModal CategoryModal = teamModalClasses.get(position);

        holder.textView_cat.setText(CategoryModal.get_catName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set ground id to fetch data
//                SubCategoryModal.id = CategoryModal.get_id();
                Intent intent = new Intent(context, SubCategoryActivity.class);
                intent.putExtra("_id",CategoryModal.get_id());
                intent.putExtra("_name",CategoryModal.get_catName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teamModalClasses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView_cat;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView_cat = itemView.findViewById(R.id.cat_name);
        }
    }
}