
package com.brewmapp.brewmapp.features.main.news.events.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvgBall {

    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("coefficient_review")
    @Expose
    private Integer coefficientReview;
    @SerializedName("coefficient_like")
    @Expose
    private Integer coefficientLike;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getCoefficientReview() {
        return coefficientReview;
    }

    public void setCoefficientReview(Integer coefficientReview) {
        this.coefficientReview = coefficientReview;
    }

    public Integer getCoefficientLike() {
        return coefficientLike;
    }

    public void setCoefficientLike(Integer coefficientLike) {
        this.coefficientLike = coefficientLike;
    }

}
