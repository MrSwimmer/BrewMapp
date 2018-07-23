
package com.brewmapp.brewmapp.features.main.adsearch.data.model.res.beer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeerFragrance {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private Name_____ name;
    @SerializedName("image")
    @Expose
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name_____ getName() {
        return name;
    }

    public void setName(Name_____ name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
