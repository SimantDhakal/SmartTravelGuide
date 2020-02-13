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
import com.simant.tourandtravel.activity.ServiceActivity;
import com.simant.tourandtravel.modal.SubCategoryModal;

import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.MyViewHolder>{

    Context context;
    List<SubCategoryModal> teamModalClasses;

    public SubCategoryAdapter(Context context, List<SubCategoryModal> teamModalClasses) {
        this.context = context;
        this.teamModalClasses = teamModalClasses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_sub_category,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //// getting data according to position
        final SubCategoryModal SubCategoryModal = teamModalClasses.get(position);

        holder.textView_cat.setText(SubCategoryModal.get_subCatName());
        holder.textView_location.setText(SubCategoryModal.get_locationName());
        holder.textView_desc.setText(SubCategoryModal.get_description());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailSubCategoryActivity.id = SubCategoryModal.get_id();
                ServiceActivity.id = SubCategoryModal.get_id();
                Intent intent = new Intent(context, DetailSubCategoryActivity.class);
//                intent.putExtra("_id", SubCategoryModal.get_id());
                intent.putExtra("_name",SubCategoryModal.get_subCatName());
                intent.putExtra("_desc",SubCategoryModal.get_description());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        // value null -> error
        return teamModalClasses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView_cat, textView_location, textView_desc;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView_cat = itemView.findViewById(R.id.subCatName);
            textView_location = itemView.findViewById(R.id.location);
            textView_desc = itemView.findViewById(R.id.desc);
        }
    }
}