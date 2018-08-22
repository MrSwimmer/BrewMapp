
package com.brewmapp.brewmapp.features.main.card.product.data.model.newmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title {

    @SerializedName("1")
    @Expose
    private String _1;
    @SerializedName("58")
    @Expose
    private String _58;

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public String get58() {
        return _58;
    }

    public void set58(String _58) {
        this._58 = _58;
    }

}
