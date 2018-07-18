
package com.brewmapp.brewmapp.features.auth.data.model.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class Country {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private HashMap<String, String> name;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("country_code")
    @Expose
    private String countryCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, String> getName() {
        return name;
    }

    public void setName(HashMap<String, String> name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
