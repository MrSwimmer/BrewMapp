
package com.brewmapp.brewmapp.features.main.card.product.data.model.resto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("resto_id")
    @Expose
    private String restoId;
    @SerializedName("resto_menu_category_id")
    @Expose
    private Object restoMenuCategoryId;
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
    private Object userId;
    @SerializedName("getThumb")
    @Expose
    private Object getThumb;
    @SerializedName("like")
    @Expose
    private String like;
    @SerializedName("dis_like")
    @Expose
    private String disLike;
    @SerializedName("interested")
    @Expose
    private String interested;
    @SerializedName("no_interested")
    @Expose
    private String noInterested;
    @SerializedName("beer_name")
    @Expose
    private BeerName beerName;
    @SerializedName("beer_avg_ball")
    @Expose
    private String beerAvgBall;
    @SerializedName("menu_category_name")
    @Expose
    private Object menuCategoryName;
    @SerializedName("getThumb_beer")
    @Expose
    private String getThumbBeer;

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

    public Object getRestoMenuCategoryId() {
        return restoMenuCategoryId;
    }

    public void setRestoMenuCategoryId(Object restoMenuCategoryId) {
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

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public Object getGetThumb() {
        return getThumb;
    }

    public void setGetThumb(Object getThumb) {
        this.getThumb = getThumb;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getDisLike() {
        return disLike;
    }

    public void setDisLike(String disLike) {
        this.disLike = disLike;
    }

    public String getInterested() {
        return interested;
    }

    public void setInterested(String interested) {
        this.interested = interested;
    }

    public String getNoInterested() {
        return noInterested;
    }

    public void setNoInterested(String noInterested) {
        this.noInterested = noInterested;
    }

    public BeerName getBeerName() {
        return beerName;
    }

    public void setBeerName(BeerName beerName) {
        this.beerName = beerName;
    }

    public String getBeerAvgBall() {
        return beerAvgBall;
    }

    public void setBeerAvgBall(String beerAvgBall) {
        this.beerAvgBall = beerAvgBall;
    }

    public Object getMenuCategoryName() {
        return menuCategoryName;
    }

    public void setMenuCategoryName(Object menuCategoryName) {
        this.menuCategoryName = menuCategoryName;
    }

    public String getGetThumbBeer() {
        return getThumbBeer;
    }

    public void setGetThumbBeer(String getThumbBeer) {
        this.getThumbBeer = getThumbBeer;
    }

}
