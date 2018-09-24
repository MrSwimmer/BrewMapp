
package com.brewmapp.brewmapp.features.main.card.resto.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Street {

    @SerializedName("1")
    @Expose
    private String _1;

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

}
