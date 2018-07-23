
package com.brewmapp.brewmapp.features.main.adsearch.data.model.res.beer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeerToColor {

    @SerializedName("beer_id")
    @Expose
    private String beerId;
    @SerializedName("color_id")
    @Expose
    private String colorId;

    public String getBeerId() {
        return beerId;
    }

    public void setBeerId(String beerId) {
        this.beerId = beerId;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

}
