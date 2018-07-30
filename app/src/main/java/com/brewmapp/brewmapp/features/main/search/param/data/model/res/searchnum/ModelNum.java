
package com.brewmapp.brewmapp.features.main.search.param.data.model.res.searchnum;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelNum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("getThumb")
    @Expose
    private String getThumb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGetThumb() {
        return getThumb;
    }

    public void setGetThumb(String getThumb) {
        this.getThumb = getThumb;
    }

}
