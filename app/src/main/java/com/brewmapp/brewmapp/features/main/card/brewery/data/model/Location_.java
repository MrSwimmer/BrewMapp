
package com.brewmapp.brewmapp.features.main.card.brewery.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location_ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("region_id")
    @Expose
    private Object regionId;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("metro_id")
    @Expose
    private Object metroId;
    @SerializedName("street")
    @Expose
    private Street street;
    @SerializedName("house")
    @Expose
    private House house;
    @SerializedName("additional")
    @Expose
    private Object additional;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("by_user_id")
    @Expose
    private String byUserId;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("lon")
    @Expose
    private Object lon;
    @SerializedName("lat")
    @Expose
    private Object lat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Object getRegionId() {
        return regionId;
    }

    public void setRegionId(Object regionId) {
        this.regionId = regionId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Object getMetroId() {
        return metroId;
    }

    public void setMetroId(Object metroId) {
        this.metroId = metroId;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Object getAdditional() {
        return additional;
    }

    public void setAdditional(Object additional) {
        this.additional = additional;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getByUserId() {
        return byUserId;
    }

    public void setByUserId(String byUserId) {
        this.byUserId = byUserId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Object getLon() {
        return lon;
    }

    public void setLon(Object lon) {
        this.lon = lon;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

}
