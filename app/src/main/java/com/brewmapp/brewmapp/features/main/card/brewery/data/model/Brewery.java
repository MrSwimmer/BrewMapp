
package com.brewmapp.brewmapp.features.main.card.brewery.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Brewery {

    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("models")
    @Expose
    private List<Model> models = null;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

}
