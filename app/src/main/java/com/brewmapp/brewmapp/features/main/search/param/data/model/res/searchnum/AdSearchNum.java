
package com.brewmapp.brewmapp.features.main.search.param.data.model.res.searchnum;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AdSearchNum {

    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("models")
    @Expose
    private List<ModelNum> models = null;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ModelNum> getModels() {
        return models;
    }

    public void setModels(List<ModelNum> models) {
        this.models = models;
    }
}
