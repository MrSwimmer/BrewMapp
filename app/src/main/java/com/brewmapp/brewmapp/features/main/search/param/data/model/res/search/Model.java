
package com.brewmapp.brewmapp.features.main.search.param.data.model.res.search;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class Model {

    @Expose
    private String price;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private HashMap<String, String> name;
    @SerializedName("getThumb")
    @Expose
    private String getThumb = "";

    @PrimaryKey(autoGenerate = true)
    Long idKey = 0L;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
