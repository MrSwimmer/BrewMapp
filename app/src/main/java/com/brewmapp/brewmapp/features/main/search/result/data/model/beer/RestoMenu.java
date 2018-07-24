
package com.brewmapp.brewmapp.features.main.search.result.data.model.beer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestoMenu {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("resto_id")
    @Expose
    private String restoId;
    @SerializedName("resto_menu_category_id")
    @Expose
    private String restoMenuCategoryId;
    @SerializedName("beer_id")
    @Expose
    private String beerId;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("old_price")
    @Expose
    private Object oldPrice;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("resto_menu_packing_id")
    @Expose
    private String restoMenuPackingId;
    @SerializedName("resto_menu_capacity_id")
    @Expose
    private String restoMenuCapacityId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("user_id")
    @Expose
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestoId() {
        return restoId;
    }

    public void setRestoId(String restoId) {
        this.restoId = restoId;
    }

    public String getRestoMenuCategoryId() {
        return restoMenuCategoryId;
    }

    public void setRestoMenuCategoryId(String restoMenuCategoryId) {
        this.restoMenuCategoryId = restoMenuCategoryId;
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

    public Object getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Object oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
