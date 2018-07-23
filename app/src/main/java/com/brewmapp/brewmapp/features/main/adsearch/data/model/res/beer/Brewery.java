
package com.brewmapp.brewmapp.features.main.adsearch.data.model.res.beer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Brewery {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private Name___ name;
    @SerializedName("location_id")
    @Expose
    private String locationId;
    @SerializedName("by_user_id")
    @Expose
    private String byUserId;
    @SerializedName("text")
    @Expose
    private Text_ text;
    @SerializedName("short_text")
    @Expose
    private ShortText_ shortText;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("avg_ball")
    @Expose
    private Object avgBall;
    @SerializedName("in_archive")
    @Expose
    private String inArchive;
    @SerializedName("timestamp")
    @Expose
    private Object timestamp;
    @SerializedName("name_ru")
    @Expose
    private String nameRu;
    @SerializedName("additional_data")
    @Expose
    private String additionalData;
    @SerializedName("advertising")
    @Expose
    private String advertising;
    @SerializedName("updated_user_id")
    @Expose
    private String updatedUserId;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("detect_language")
    @Expose
    private String detectLanguage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name___ getName() {
        return name;
    }

    public void setName(Name___ name) {
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

    public Text_ getText() {
        return text;
    }

    public void setText(Text_ text) {
        this.text = text;
    }

    public ShortText_ getShortText() {
        return shortText;
    }

    public void setShortText(ShortText_ shortText) {
        this.shortText = shortText;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Object getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Object timestamp) {
        this.timestamp = timestamp;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
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

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDetectLanguage() {
        return detectLanguage;
    }

    public void setDetectLanguage(String detectLanguage) {
        this.detectLanguage = detectLanguage;
    }

}
