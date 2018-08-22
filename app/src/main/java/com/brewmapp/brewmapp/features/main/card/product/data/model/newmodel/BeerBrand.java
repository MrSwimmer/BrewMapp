
package com.brewmapp.brewmapp.features.main.card.product.data.model.newmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeerBrand {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("timestamp")
    @Expose
    private Object timestamp;
    @SerializedName("name_ru")
    @Expose
    private Object nameRu;
    @SerializedName("country_id")
    @Expose
    private Object countryId;
    @SerializedName("brewery_id")
    @Expose
    private Object breweryId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Object timestamp) {
        this.timestamp = timestamp;
    }

    public Object getNameRu() {
        return nameRu;
    }

    public void setNameRu(Object nameRu) {
        this.nameRu = nameRu;
    }

    public Object getCountryId() {
        return countryId;
    }

    public void setCountryId(Object countryId) {
        this.countryId = countryId;
    }

    public Object getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(Object breweryId) {
        this.breweryId = breweryId;
    }

}
