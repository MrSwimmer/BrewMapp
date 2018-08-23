
package com.brewmapp.brewmapp.features.main.card.product.data.model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeerAftertaste {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private Name_______ name;
    @SerializedName("image")
    @Expose
    private Object image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name_______ getName() {
        return name;
    }

    public void setName(Name_______ name) {
        this.name = name;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

}
