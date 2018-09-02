
package com.brewmapp.brewmapp.features.main.card.brewery.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("location")
    @Expose
    private Location_ location;
    @SerializedName("city_id")
    @Expose
    private Object cityId;
    @SerializedName("metro")
    @Expose
    private Object metro;

    public Location_ getLocation() {
        return location;
    }

    public void setLocation(Location_ location) {
        this.location = location;
    }

    public Object getCityId() {
        return cityId;
    }

    public void setCityId(Object cityId) {
        this.cityId = cityId;
    }

    public Object getMetro() {
        return metro;
    }

    public void setMetro(Object metro) {
        this.metro = metro;
    }

}
