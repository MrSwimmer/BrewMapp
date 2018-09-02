
package com.brewmapp.brewmapp.features.main.card.product.data.model.review;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserGetThumb_ {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("url_preview")
    @Expose
    private String urlPreview;
    @SerializedName("front_photo")
    @Expose
    private String frontPhoto;
    @SerializedName("size")
    @Expose
    private Size_ size;
    @SerializedName("like")
    @Expose
    private String like;
    @SerializedName("dis_like")
    @Expose
    private String disLike;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlPreview() {
        return urlPreview;
    }

    public void setUrlPreview(String urlPreview) {
        this.urlPreview = urlPreview;
    }

    public String getFrontPhoto() {
        return frontPhoto;
    }

    public void setFrontPhoto(String frontPhoto) {
        this.frontPhoto = frontPhoto;
    }

    public Size_ getSize() {
        return size;
    }

    public void setSize(Size_ size) {
        this.size = size;
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

}
