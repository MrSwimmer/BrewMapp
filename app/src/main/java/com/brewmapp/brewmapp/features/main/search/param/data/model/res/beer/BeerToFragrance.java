
package com.brewmapp.brewmapp.features.main.search.param.data.model.res.beer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeerToFragrance {

    @SerializedName("beer_id")
    @Expose
    private String beerId;
    @SerializedName("fragrance_id")
    @Expose
    private String fragranceId;

    public String getBeerId() {
        return beerId;
    }

    public void setBeerId(String beerId) {
        this.beerId = beerId;
    }

    public String getFragranceId() {
        return fragranceId;
    }

    public void setFragranceId(String fragranceId) {
        this.fragranceId = fragranceId;
    }

}
