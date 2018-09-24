
package com.brewmapp.brewmapp.features.main.card.resto.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metro {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("name")
    @Expose
    private Name_ name;
    @SerializedName("lon")
    @Expose
    private String lon;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("distance")
    @Expose
    private Integer distance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Name_ getName() {
        return name;
    }

    public void setName(Name_ name) {
        this.name = name;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

}
