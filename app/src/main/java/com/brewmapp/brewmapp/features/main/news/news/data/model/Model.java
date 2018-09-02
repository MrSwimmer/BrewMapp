
package com.brewmapp.brewmapp.features.main.news.news.data.model;

import java.util.HashMap;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("related_model")
    @Expose
    private String relatedModel;
    @SerializedName("related_id")
    @Expose
    private String relatedId;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("text")
    @Expose
    private HashMap<String, String> text;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("date_news")
    @Expose
    private String dateNews;
    @SerializedName("lon")
    @Expose
    private Object lon;
    @SerializedName("lat")
    @Expose
    private Object lat;
    @SerializedName("hashtag")
    @Expose
    private String hashtag;
    @SerializedName("repost_model")
    @Expose
    private Object repostModel;
    @SerializedName("repost_id")
    @Expose
    private Object repostId;
    @SerializedName("only_friends")
    @Expose
    private String onlyFriends;
    @SerializedName("by_user_id")
    @Expose
    private String byUserId;
    @SerializedName("location_id")
    @Expose
    private Object locationId;
    @SerializedName("post_vk")
    @Expose
    private String postVk;
    @SerializedName("post_instagram")
    @Expose
    private String postInstagram;
    @SerializedName("post_rss")
    @Expose
    private String postRss;
    @SerializedName("detect_language")
    @Expose
    private Object detectLanguage;
    @SerializedName("is_consolidate")
    @Expose
    private Object isConsolidate;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("model_link")
    @Expose
    private String modelLink;
    @SerializedName("getThumb")
    @Expose
    private Object getThumb;
    @SerializedName("photo")
    @Expose
    private List<Photo> photo = null;
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
    @SerializedName("related_model_data")
    @Expose
    private RelatedModelData relatedModelData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelatedModel() {
        return relatedModel;
    }

    public void setRelatedModel(String relatedModel) {
        this.relatedModel = relatedModel;
    }

    public String getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(String relatedId) {
        this.relatedId = relatedId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public HashMap<String, String> getText() {
        return text;
    }

    public void setText(HashMap<String, String> text) {
        this.text = text;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDateNews() {
        return dateNews;
    }

    public void setDateNews(String dateNews) {
        this.dateNews = dateNews;
    }

    public Object getLon() {
        return lon;
    }

    public void setLon(Object lon) {
        this.lon = lon;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public Object getRepostModel() {
        return repostModel;
    }

    public void setRepostModel(Object repostModel) {
        this.repostModel = repostModel;
    }

    public Object getRepostId() {
        return repostId;
    }

    public void setRepostId(Object repostId) {
        this.repostId = repostId;
    }

    public String getOnlyFriends() {
        return onlyFriends;
    }

    public void setOnlyFriends(String onlyFriends) {
        this.onlyFriends = onlyFriends;
    }

    public String getByUserId() {
        return byUserId;
    }

    public void setByUserId(String byUserId) {
        this.byUserId = byUserId;
    }

    public Object getLocationId() {
        return locationId;
    }

    public void setLocationId(Object locationId) {
        this.locationId = locationId;
    }

    public String getPostVk() {
        return postVk;
    }

    public void setPostVk(String postVk) {
        this.postVk = postVk;
    }

    public String getPostInstagram() {
        return postInstagram;
    }

    public void setPostInstagram(String postInstagram) {
        this.postInstagram = postInstagram;
    }

    public String getPostRss() {
        return postRss;
    }

    public void setPostRss(String postRss) {
        this.postRss = postRss;
    }

    public Object getDetectLanguage() {
        return detectLanguage;
    }

    public void setDetectLanguage(Object detectLanguage) {
        this.detectLanguage = detectLanguage;
    }

    public Object getIsConsolidate() {
        return isConsolidate;
    }

    public void setIsConsolidate(Object isConsolidate) {
        this.isConsolidate = isConsolidate;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getModelLink() {
        return modelLink;
    }

    public void setModelLink(String modelLink) {
        this.modelLink = modelLink;
    }

    public Object getGetThumb() {
        return getThumb;
    }

    public void setGetThumb(Object getThumb) {
        this.getThumb = getThumb;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
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

    public RelatedModelData getRelatedModelData() {
        return relatedModelData;
    }

    public void setRelatedModelData(RelatedModelData relatedModelData) {
        this.relatedModelData = relatedModelData;
    }

}
