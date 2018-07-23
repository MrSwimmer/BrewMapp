
package com.brewmapp.brewmapp.features.main.adsearch.data.model.res.beer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeerToTaste {

    @SerializedName("beer_id")
    @Expose
    private String beerId;
    @SerializedName("taste_id")
    @Expose
    private String tasteId;

    public String getBeerId() {
        return beerId;
    }

    public void setBeerId(String beerId) {
        this.beerId = beerId;
    }

    public String getTasteId() {
        return tasteId;
    }

    public void setTasteId(String tasteId) {
        this.tasteId = tasteId;
    }

}
