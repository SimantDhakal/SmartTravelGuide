package com.simant.tourandtravel.modal;

public class PostReviewModal {
    public PostReviewModal(String userId, String comment, Float rating, String productId) {
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String userId;
    private String comment;
    private Float rating;
    private String productId;


}
