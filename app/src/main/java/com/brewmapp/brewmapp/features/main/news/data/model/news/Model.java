
package com.brewmapp.brewmapp.features.main.news.data.model.news;

import java.util.HashMap;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("text")
    @Expose
    private HashMap<String, String> text;

    @SerializedName("timestamp")
    @Expose
    private String timestamp;

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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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

    public HashMap<String, String> getText() {
        return text;
    }

    public void setText(HashMap<String, String> text) {
        this.text = text;
    }

    public String getGetThumb() {
        return getThumb;
    }

    public void setGetThumb(String getThumb) {
        this.getThumb = getThumb;
    }

    public Model(String id, HashMap<String, String> text, String timestamp, String getThumb, String like, String disLike, String interested, String noInterested) {
        this.id = id;
        this.text = text;
        this.timestamp = timestamp;
        this.getThumb = getThumb;
        this.like = like;
        this.disLike = disLike;
        this.interested = interested;
        this.noInterested = noInterested;
    }
}
