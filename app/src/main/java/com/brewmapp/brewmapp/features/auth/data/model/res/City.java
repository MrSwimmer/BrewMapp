
package com.brewmapp.brewmapp.features.auth.data.model.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class City {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private HashMap<String, String> name;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("region_id")
    @Expose
    private String regionId;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("phone_code")
    @Expose
    private String phoneCode;

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

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

}
