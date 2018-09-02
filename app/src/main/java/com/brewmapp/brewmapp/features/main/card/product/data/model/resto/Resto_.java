
package com.brewmapp.brewmapp.features.main.card.product.data.model.resto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resto_ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("disposition_id")
    @Expose
    private String dispositionId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("site")
    @Expose
    private String site;
    @SerializedName("music")
    @Expose
    private String music;
    @SerializedName("lunch_price")
    @Expose
    private String lunchPrice;
    @SerializedName("avg_cost")
    @Expose
    private String avgCost;
    @SerializedName("avg_cost_max")
    @Expose
    private String avgCostMax;
    @SerializedName("yes_count")
    @Expose
    private Object yesCount;
    @SerializedName("no_count")
    @Expose
    private Object noCount;
    @SerializedName("avg_ball")
    @Expose
    private String avgBall;
    @SerializedName("wall_count")
    @Expose
    private Object wallCount;
    @SerializedName("photo_count")
    @Expose
    private String photoCount;
    @SerializedName("video_count")
    @Expose
    private Object videoCount;
    @SerializedName("review_count")
    @Expose
    private Object reviewCount;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("advertising")
    @Expose
    private String advertising;
    @SerializedName("gpa")
    @Expose
    private String gpa;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("in_archive")
    @Expose
    private String inArchive;
    @SerializedName("additional_data")
    @Expose
    private String additionalData;
    @SerializedName("type_id")
    @Expose
    private Object typeId;
    @SerializedName("round_clock")
    @Expose
    private String roundClock;
    @SerializedName("name_en")
    @Expose
    private Object nameEn;
    @SerializedName("updated_user_id")
    @Expose
    private Object updatedUserId;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("detect_language")
    @Expose
    private Object detectLanguage;
    @SerializedName("location_id")
    @Expose
    private String locationId;
    @SerializedName("getThumb")
    @Expose
    private String getThumb;
    @SerializedName("photo")
    @Expose
    private List<Photo> photo = null;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("user_info")
    @Expose
    private UserInfo userInfo;
    @SerializedName("user_getThumb")
    @Expose
    private UserGetThumb userGetThumb;
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
    private Text text;

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

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

    public String getDispositionId() {
        return dispositionId;
    }

    public void setDispositionId(String dispositionId) {
        this.dispositionId = dispositionId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getLunchPrice() {
        return lunchPrice;
    }

    public void setLunchPrice(String lunchPrice) {
        this.lunchPrice = lunchPrice;
    }

    public String getAvgCost() {
        return avgCost;
    }

    public void setAvgCost(String avgCost) {
        this.avgCost = avgCost;
    }

    public String getAvgCostMax() {
        return avgCostMax;
    }

    public void setAvgCostMax(String avgCostMax) {
        this.avgCostMax = avgCostMax;
    }

    public Object getYesCount() {
        return yesCount;
    }

    public void setYesCount(Object yesCount) {
        this.yesCount = yesCount;
    }

    public Object getNoCount() {
        return noCount;
    }

    public void setNoCount(Object noCount) {
        this.noCount = noCount;
    }

    public String getAvgBall() {
        return avgBall;
    }

    public void setAvgBall(String avgBall) {
        this.avgBall = avgBall;
    }

    public Object getWallCount() {
        return wallCount;
    }

    public void setWallCount(Object wallCount) {
        this.wallCount = wallCount;
    }

    public String getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(String photoCount) {
        this.photoCount = photoCount;
    }

    public Object getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Object videoCount) {
        this.videoCount = videoCount;
    }

    public Object getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Object reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String advertising) {
        this.advertising = advertising;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getInArchive() {
        return inArchive;
    }

    public void setInArchive(String inArchive) {
        this.inArchive = inArchive;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public Object getTypeId() {
        return typeId;
    }

    public void setTypeId(Object typeId) {
        this.typeId = typeId;
    }

    public String getRoundClock() {
        return roundClock;
    }

    public void setRoundClock(String roundClock) {
        this.roundClock = roundClock;
    }

    public Object getNameEn() {
        return nameEn;
    }

    public void setNameEn(Object nameEn) {
        this.nameEn = nameEn;
    }

    public Object getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Object updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDetectLanguage() {
        return detectLanguage;
    }

    public void setDetectLanguage(Object detectLanguage) {
        this.detectLanguage = detectLanguage;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getGetThumb() {
        return getThumb;
    }

    public void setGetThumb(String getThumb) {
        this.getThumb = getThumb;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserGetThumb getUserGetThumb() {
        return userGetThumb;
    }

    public void setUserGetThumb(UserGetThumb userGetThumb) {
        this.userGetThumb = userGetThumb;
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
