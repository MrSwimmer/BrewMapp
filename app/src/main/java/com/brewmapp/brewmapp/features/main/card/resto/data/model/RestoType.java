
package com.brewmapp.brewmapp.features.main.card.resto.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestoType {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private Name____ name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("getThumb")
    @Expose
    private String getThumb;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name____ getName() {
        return name;
    }

    public void setName(Name____ name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGetThumb() {
        return getThumb;
    }

    public void setGetThumb(String getThumb) {
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

}
