package com.simant.tourandtravel.adapter;

//public class ReviewAdapter {
//}

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.simant.tourandtravel.R;
import com.simant.tourandtravel.modal.ReviewModal;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.MyViewHolder>{

    Context context;
    List<ReviewModal> teamModalClasses;

    public ReviewAdapter(Context context, List<ReviewModal> teamModalClasses) {
        this.context = context;
        this.teamModalClasses = teamModalClasses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_review,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //// getting data according to position
        final ReviewModal ReviewModal = teamModalClasses.get(position);

        holder.textView_name.setText(ReviewModal.get_fullName());
        holder.textView_review.setText(ReviewModal.get_comment());
        holder.ratingBar.setRating(Float.parseFloat(ReviewModal.get_rating()));

    }

    @Override
    public int getItemCount() {
        return teamModalClasses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView_name, textView_review;
        RatingBar ratingBar;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView_name = itemView.findViewById(R.id.etName);
            textView_review = itemView.findViewById(R.id.etReview);
            ratingBar = itemView.findViewById(R.id.rate);
        }
    }
}