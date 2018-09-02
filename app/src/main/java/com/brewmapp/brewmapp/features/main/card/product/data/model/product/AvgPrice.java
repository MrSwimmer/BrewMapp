
package com.brewmapp.brewmapp.features.main.card.product.data.model.product;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class AvgPrice {

    @SerializedName("beer_id")
    private String beerId;
    @SerializedName("country_id")
    private String countryId;
    @SerializedName("created_at")
    private String createdAt;
    @Expose
    private String id;
    @Expose
    private String price;
    @SerializedName("resto_menu_capacity_id")
    private String restoMenuCapacityId;
    @SerializedName("resto_menu_packing_id")
    private String restoMenuPackingId;

    public String getBeerId() {
        return beerId;
    }

    public void setBeerId(String beerId) {
        this.beerId = beerId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRestoMenuCapacityId() {
        return restoMenuCapacityId;
    }

    public void setRestoMenuCapacityId(String restoMenuCapacityId) {
        this.restoMenuCapacityId = restoMenuCapacityId;
    }

    public String getRestoMenuPackingId() {
        return restoMenuPackingId;
    }

    public void setRestoMenuPackingId(String restoMenuPackingId) {
        this.restoMenuPackingId = restoMenuPackingId;
    }

}
