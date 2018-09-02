
package com.brewmapp.brewmapp.features.main.card.product.data.model.review;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("models")
    @Expose
    private List<Model> models = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

}
