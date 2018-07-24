
package com.brewmapp.brewmapp.features.main.search.result.data.model.beer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeerToAftertaste {

    @SerializedName("beer_id")
    @Expose
    private String beerId;
    @SerializedName("aftertaste_id")
    @Expose
    private String aftertasteId;

    public String getBeerId() {
        return beerId;
    }

    public void setBeerId(String beerId) {
        this.beerId = beerId;
    }

    public String getAftertasteId() {
        return aftertasteId;
    }

    public void setAftertasteId(String aftertasteId) {
        this.aftertasteId = aftertasteId;
    }

}
