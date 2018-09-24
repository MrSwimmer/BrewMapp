
package com.brewmapp.brewmapp.features.main.card.brewery.data.model;

import com.brewmapp.brewmapp.features.main.card.resto.data.model.Text;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("location_id")
    @Expose
    private String locationId;
    @SerializedName("by_user_id")
    @Expose
    private String byUserId;
    @SerializedName("text")
    @Expose
    private Text text = null;
    @SerializedName("avg_ball")
    @Expose
    private Object avgBall;
    @SerializedName("in_archive")
    @Expose
    private String inArchive;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("name_ru")
    @Expose
    private Object nameRu;
    @SerializedName("additional_data")
    @Expose
    private String additionalData;
    @SerializedName("advertising")
    @Expose
    private String advertising;
    @SerializedName("updated_user_id")
    @Expose
    private Object updatedUserId;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("detect_language")
    @Expose
    private Object detectLanguage;
    @SerializedName("getThumb")
    @Expose
    private Object getThumb;
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
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("news_count")
    @Expose
    private String newsCount;
    @SerializedName("shares_count")
    @Expose
    private String sharesCount;
    @SerializedName("vacancies_count")
    @Expose
    private String vacanciesCount;
    @SerializedName("employees_count")
    @Expose
    private String employeesCount;
    @SerializedName("event_count")
    @Expose
    private String eventCount;
    @SerializedName("beer_count")
    @Expose
    private String beerCount;

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

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getByUserId() {
        return byUserId;
    }

    public void setByUserId(String byUserId) {
        this.byUserId = byUserId;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Object getAvgBall() {
        return avgBall;
    }

    public void setAvgBall(Object avgBall) {
        this.avgBall = avgBall;
    }

    public String getInArchive() {
        return inArchive;
    }

    public void setInArchive(String inArchive) {
        this.inArchive = inArchive;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Object getNameRu() {
        return nameRu;
    }

    public void setNameRu(Object nameRu) {
        this.nameRu = nameRu;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public String getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String advertising) {
        this.advertising = advertising;
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

    public Object getGetThumb() {
        return getThumb;
    }

    public void setGetThumb(Object getThumb) {
        this.getThumb = getThumb;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(String newsCount) {
        this.newsCount = newsCount;
    }

    public String getSharesCount() {
        return sharesCount;
    }

    public void setSharesCount(String sharesCount) {
        this.sharesCount = sharesCount;
    }

    public String getVacanciesCount() {
        return vacanciesCount;
    }

    public void setVacanciesCount(String vacanciesCount) {
        this.vacanciesCount = vacanciesCount;
    }

    public String getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(String employeesCount) {
        this.employeesCount = employeesCount;
    }

    public String getEventCount() {
        return eventCount;
    }

    public void setEventCount(String eventCount) {
        this.eventCount = eventCount;
    }

    public String getBeerCount() {
        return beerCount;
    }

    public void setBeerCount(String beerCount) {
        this.beerCount = beerCount;
    }

}
