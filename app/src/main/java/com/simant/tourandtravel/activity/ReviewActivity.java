package com.simant.tourandtravel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.simant.tourandtravel.R;
import com.simant.tourandtravel.adapter.ReviewAdapter;
import com.simant.tourandtravel.api.BaseURL;
import com.simant.tourandtravel.api.Interface;
import com.simant.tourandtravel.modal.PostReviewModal;
import com.simant.tourandtravel.modal.ReviewModal;
import com.simant.tourandtravel.modal.UserModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReviewActivity extends AppCompatActivity {

    public static String id = null;
    public static String userID = null;
    RecyclerView recyclerView;
    EditText et_review;
    RatingBar ratingBar;
    Button btn_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        recyclerView = findViewById(R.id.recyclerview_review);
        getSupportActionBar().hide();
        et_review = findViewById(R.id.etReview);
        ratingBar = findViewById(R.id.rate);
        btn_post = findViewById(R.id.btnPost);

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postReview();
            }
        });

        getReview(id);
    }

    public void getReview(String product){
        Interface retrofitApiInterface = BaseURL.getInstance().create(Interface.class);
        Call<List<ReviewModal>> modalClassCall = retrofitApiInterface.loadReview(product);

        modalClassCall.enqueue(new Callback<List<ReviewModal>>() {
            @Override
            public void onResponse(Call<List<ReviewModal>> call, Response<List<ReviewModal>>
                    response) {
                ReviewAdapter recyclerviewAdapter = new ReviewAdapter
                        (getApplicationContext(),response.body());
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(horizontalLayoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recyclerviewAdapter);
                recyclerviewAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<ReviewModal>> call, Throwable t) {
            }
        });
    }

    private void postReview() {
        String review= et_review.getText().toString();
        Float rate = ratingBar.getRating();

        PostReviewModal reviewModal = new PostReviewModal(userID, review, rate, id);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Interface userInt = retrofit.create(Interface.class);
        Call<Void> voidCall = userInt.postReview(reviewModal);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println("User" + response.body());
                Toast.makeText(getApplicationContext(), "Review successfully submitted!!", Toast.LENGTH_LONG).show();
                finish();
                startActivity(getIntent());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}