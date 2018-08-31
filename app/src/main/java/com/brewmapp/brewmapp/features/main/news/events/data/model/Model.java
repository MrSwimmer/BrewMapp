
package com.brewmapp.brewmapp.features.main.news.events.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("text")
    @Expose
    private Text text;
    @SerializedName("short_text")
    @Expose
    private ShortText shortText;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("location_id")
    @Expose
    private String locationId;
    @SerializedName("review_count")
    @Expose
    private Object reviewCount;
    @SerializedName("date_from")
    @Expose
    private String dateFrom;
    @SerializedName("date_to")
    @Expose
    private String dateTo;
    @SerializedName("time_from")
    @Expose
    private String timeFrom;
    @SerializedName("time_to")
    @Expose
    private String timeTo;
    @SerializedName("date_time_start_event")
    @Expose
    private String dateTimeStartEvent;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("hashtag")
    @Expose
    private String hashtag;
    @SerializedName("is_weekly")
    @Expose
    private Object isWeekly;
    @SerializedName("detect_language")
    @Expose
    private Object detectLanguage;
    @SerializedName("model_link")
    @Expose
    private Object modelLink;
    @SerializedName("getThumb")
    @Expose
    private Object getThumb;
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
    private Object userGetThumb;
    @SerializedName("resto_info")
    @Expose
    private RestoInfo restoInfo;
    @SerializedName("user_resto_admin")
    @Expose
    private Integer userRestoAdmin;
    @SerializedName("avg_ball")
    @Expose
    private AvgBall avgBall;
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
    @SerializedName("i_will_co")
    @Expose
    private String iWillCo;
    @SerializedName("invited")
    @Expose
    private String invited;

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

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public ShortText getShortText() {
        return shortText;
    }

    public void setShortText(ShortText shortText) {
        this.shortText = shortText;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public Object getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Object reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public String getDateTimeStartEvent() {
        return dateTimeStartEvent;
    }

    public void setDateTimeStartEvent(String dateTimeStartEvent) {
        this.dateTimeStartEvent = dateTimeStartEvent;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public Object getIsWeekly() {
        return isWeekly;
    }

    public void setIsWeekly(Object isWeekly) {
        this.isWeekly = isWeekly;
    }

    public Object getDetectLanguage() {
        return detectLanguage;
    }

    public void setDetectLanguage(Object detectLanguage) {
        this.detectLanguage = detectLanguage;
    }

    public Object getModelLink() {
        return modelLink;
    }

    public void setModelLink(Object modelLink) {
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

    public Object getUserGetThumb() {
        return userGetThumb;
    }

    public void setUserGetThumb(Object userGetThumb) {
        this.userGetThumb = userGetThumb;
    }

    public RestoInfo getRestoInfo() {
        return restoInfo;
    }

    public void setRestoInfo(RestoInfo restoInfo) {
        this.restoInfo = restoInfo;
    }

    public Integer getUserRestoAdmin() {
        return userRestoAdmin;
    }

    public void setUserRestoAdmin(Integer userRestoAdmin) {
        this.userRestoAdmin = userRestoAdmin;
    }

    public AvgBall getAvgBall() {
        return avgBall;
    }

    public void setAvgBall(AvgBall avgBall) {
        this.avgBall = avgBall;
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

    public String getIWillCo() {
        return iWillCo;
    }

    public void setIWillCo(String iWillCo) {
        this.iWillCo = iWillCo;
    }

    public String getInvited() {
        return invited;
    }

    public void setInvited(String invited) {
        this.invited = invited;
    }

}
