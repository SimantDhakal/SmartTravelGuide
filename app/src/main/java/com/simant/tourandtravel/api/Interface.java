package com.simant.tourandtravel.api;

import com.simant.tourandtravel.Bll.SignUpResponse;
import com.simant.tourandtravel.modal.CategoryModal;
import com.simant.tourandtravel.modal.PostReviewModal;
import com.simant.tourandtravel.modal.ProductModal;
import com.simant.tourandtravel.modal.ReviewModal;
import com.simant.tourandtravel.modal.SubCategoryModal;
import com.simant.tourandtravel.modal.UserModal;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Interface {

    //register user
    @POST("users")
    Call<Void> registerUser(@Body UserModal usersCUD);

    //for logging into the system
    @FormUrlEncoded
    @POST("users/login")
    Call<SignUpResponse> checkUser(@Field("email") String email, @Field("password") String password);

    @GET("category")
    Call<List<CategoryModal>> getCategory();

    @FormUrlEncoded
    @POST("subCategory/getSubCat")
    Call<List<SubCategoryModal>> loadSubCategory(@Field("_catId") String _catId);

    @FormUrlEncoded
    @POST("products/getProductLimit")
    Call<List<ProductModal>> loadProduct(@Field("product") String product);

    @FormUrlEncoded
    @POST("products/getProductUnlimit")
    Call<List<ProductModal>> loadProductUnlimit(@Field("product") String product);

    @FormUrlEncoded
    @POST("productReview/productReviews")
    Call<List<ReviewModal>> loadReview(@Field("productId") String product);

    @POST("productReview")
    Call<Void> postReview(@Body PostReviewModal postReviewModal);

}
