package com.simant.tourandtravel.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseURL {
    public static final String base_url = "http://192.168.137.1:3003/";
    public static final String image_url="http://192.168.137.1:3003/uploads/";
    public static String token = "Bearer ";

    public static Retrofit getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}