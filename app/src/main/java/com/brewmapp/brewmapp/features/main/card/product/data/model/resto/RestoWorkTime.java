
package com.brewmapp.brewmapp.features.main.card.product.data.model.resto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestoWorkTime {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("resto_id")
    @Expose
    private String restoId;
    @SerializedName("time_start")
    @Expose
    private String timeStart;
    @SerializedName("time_end")
    @Expose
    private String timeEnd;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("user_id")
    @Expose
    private Object userId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("unti_last_guest")
    @Expose
    private String untiLastGuest;
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

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUntiLastGuest() {
        return untiLastGuest;
    }

    public void setUntiLastGuest(String untiLastGuest) {
        this.untiLastGuest = untiLastGuest;
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

}
