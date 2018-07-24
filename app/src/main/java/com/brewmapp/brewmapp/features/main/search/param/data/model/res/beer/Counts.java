
package com.brewmapp.brewmapp.features.main.search.param.data.model.res.beer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Counts {

    @SerializedName("Review")
    @Expose
    private Integer review;
    @SerializedName("Approval")
    @Expose
    private Integer approval;

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Integer getApproval() {
        return approval;
    }

    public void setApproval(Integer approval) {
        this.approval = approval;
    }

}
