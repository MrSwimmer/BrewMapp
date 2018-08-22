
package com.brewmapp.brewmapp.features.main.card.product.data.model.newmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Counts {

    @SerializedName("Review")
    @Expose
    private Integer review;
    @SerializedName("Like")
    @Expose
    private Integer like;

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

}
