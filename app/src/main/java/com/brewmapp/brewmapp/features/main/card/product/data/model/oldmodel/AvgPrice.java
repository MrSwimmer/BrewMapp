
package com.brewmapp.brewmapp.features.main.card.product.data.model.oldmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvgPrice {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("resto_menu_packing_id")
    @Expose
    private String restoMenuPackingId;
    @SerializedName("resto_menu_capacity_id")
    @Expose
    private String restoMenuCapacityId;
    @SerializedName("beer_id")
    @Expose
    private String beerId;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("country_id")
    @Expose
    private String countryId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestoMenuPackingId() {
        return restoMenuPackingId;
    }

    public void setRestoMenuPackingId(String restoMenuPackingId) {
        this.restoMenuPackingId = restoMenuPackingId;
    }

    public String getRestoMenuCapacityId() {
        return restoMenuCapacityId;
    }

    public void setRestoMenuCapacityId(String restoMenuCapacityId) {
        this.restoMenuCapacityId = restoMenuCapacityId;
    }

    public String getBeerId() {
        return beerId;
    }

    public void setBeerId(String beerId) {
        this.beerId = beerId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

}
