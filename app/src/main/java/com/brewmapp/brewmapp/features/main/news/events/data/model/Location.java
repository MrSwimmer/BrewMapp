
package com.brewmapp.brewmapp.features.main.news.events.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("location")
    @Expose
    private Location_ location;
    @SerializedName("city_id")
    @Expose
    private CityId cityId;
    @SerializedName("metro")
    @Expose
    private Metro metro;

    public Location_ getLocation() {
        return location;
    }

    public void setLocation(Location_ location) {
        this.location = location;
    }

    public CityId getCityId() {
        return cityId;
    }

    public void setCityId(CityId cityId) {
        this.cityId = cityId;
    }

    public Metro getMetro() {
        return metro;
    }

    public void setMetro(Metro metro) {
        this.metro = metro;
    }

}
