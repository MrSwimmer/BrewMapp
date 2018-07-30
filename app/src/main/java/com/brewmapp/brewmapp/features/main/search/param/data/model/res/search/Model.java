
package com.brewmapp.brewmapp.features.main.search.param.data.model.res.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class Model {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private HashMap<String, String> name;
    @SerializedName("getThumb")
    @Expose
    private String getThumb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGetThumb() {
        return getThumb;
    }

    public void setGetThumb(String getThumb) {
        this.getThumb = getThumb;
    }

    public HashMap<String, String> getName() {
        return name;
    }

    public void setName(HashMap<String, String> name) {
        this.name = name;
    }

    public Model(String id, HashMap<String, String> name, String getThumb) {
        this.id = id;
        this.name = name;
        this.getThumb = getThumb;
    }
}
