
package com.brewmapp.brewmapp.features.main.card.resto.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Size_ {

    @SerializedName("0")
    @Expose
    private Integer _0;
    @SerializedName("1")
    @Expose
    private Integer _1;
    @SerializedName("2")
    @Expose
    private Integer _2;
    @SerializedName("3")
    @Expose
    private String _3;
    @SerializedName("bits")
    @Expose
    private Integer bits;
    @SerializedName("mime")
    @Expose
    private String mime;

    public Integer get0() {
        return _0;
    }

    public void set0(Integer _0) {
        this._0 = _0;
    }

    public Integer get1() {
        return _1;
    }

    public void set1(Integer _1) {
        this._1 = _1;
    }

    public Integer get2() {
        return _2;
    }

    public void set2(Integer _2) {
        this._2 = _2;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public Integer getBits() {
        return bits;
    }

    public void setBits(Integer bits) {
        this.bits = bits;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

}
