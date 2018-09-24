
package com.brewmapp.brewmapp.features.main.map.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("resto_id")
    @Expose
    private String restoId;
    @SerializedName("location_id")
    @Expose
    private String locationId;
    @SerializedName("location_lon")
    @Expose
    private String locationLon;
    @SerializedName("location_lat")
    @Expose
    private String locationLat;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("advertising")
    @Expose
    private String advertising;

    public String getRestoId() {
        return restoId;
    }

    public void setRestoId(String restoId) {
        this.restoId = restoId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationLon() {
        return locationLon;
    }

    public void setLocationLon(String locationLon) {
        this.locationLon = locationLon;
    }

    public String getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(String locationLat) {
        this.locationLat = locationLat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String advertising) {
        this.advertising = advertising;
    }

}
