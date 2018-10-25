
package com.brewmapp.brewmapp.features.main.news.review.data.model;

import java.util.HashMap;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedModelData {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("brand_id")
    @Expose
    private String brandId;
    @SerializedName("type_id")
    @Expose
    private String typeId;
    @SerializedName("product_density_id")
    @Expose
    private String productDensityId;
    @SerializedName("product_ibu_id")
    @Expose
    private String productIbuId;
    @SerializedName("product_ibu")
    @Expose
    private Object productIbu;
    @SerializedName("strength_id")
    @Expose
    private String strengthId;
    @SerializedName("brewery_id")
    @Expose
    private String breweryId;
    @SerializedName("capacity_id")
    @Expose
    private Object capacityId;
    @SerializedName("pricerange_id")
    @Expose
    private Object pricerangeId;
    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("name")
    @Expose
    private Name name;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @SerializedName("title_ru")
    @Expose
    private String titleRu;
    @SerializedName("text")
    @Expose
    private HashMap<String, String> text;
    @SerializedName("avg_ball")
    @Expose
    private String avgBall;
    @SerializedName("by_user_id")
    @Expose
    private String byUserId;
    @SerializedName("craft")
    @Expose
    private String craft;
    @SerializedName("filtered")
    @Expose
    private String filtered;
    @SerializedName("alias_whell")
    @Expose
    private String aliasWhell;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("detect_language")
    @Expose
    private String detectLanguage;
    @SerializedName("updated_user_id")
    @Expose
    private Object updatedUserId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("getThumb")
    @Expose
    private GetThumb getThumb;
    @SerializedName("user_info")
    @Expose
    private UserInfo_ userInfo;
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
    @SerializedName("evaluation")
    @Expose
    private List<Evaluation> evaluation = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getProductDensityId() {
        return productDensityId;
    }

    public void setProductDensityId(String productDensityId) {
        this.productDensityId = productDensityId;
    }

    public String getProductIbuId() {
        return productIbuId;
    }

    public void setProductIbuId(String productIbuId) {
        this.productIbuId = productIbuId;
    }

    public Object getProductIbu() {
        return productIbu;
    }

    public void setProductIbu(Object productIbu) {
        this.productIbu = productIbu;
    }

    public String getStrengthId() {
        return strengthId;
    }

    public void setStrengthId(String strengthId) {
        this.strengthId = strengthId;
    }

    public String getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(String breweryId) {
        this.breweryId = breweryId;
    }

    public Object getCapacityId() {
        return capacityId;
    }

    public void setCapacityId(Object capacityId) {
        this.capacityId = capacityId;
    }

    public Object getPricerangeId() {
        return pricerangeId;
    }

    public void setPricerangeId(Object pricerangeId) {
        this.pricerangeId = pricerangeId;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getTitleRu() {
        return titleRu;
    }

    public void setTitleRu(String titleRu) {
        this.titleRu = titleRu;
    }

    public HashMap<String, String> getText() {
        return text;
    }

    public void setText(HashMap<String, String> text) {
        this.text = text;
    }

    public String getAvgBall() {
        return avgBall;
    }

    public void setAvgBall(String avgBall) {
        this.avgBall = avgBall;
    }

    public String getByUserId() {
        return byUserId;
    }

    public void setByUserId(String byUserId) {
        this.byUserId = byUserId;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getFiltered() {
        return filtered;
    }

    public void setFiltered(String filtered) {
        this.filtered = filtered;
    }

    public String getAliasWhell() {
        return aliasWhell;
    }

    public void setAliasWhell(String aliasWhell) {
        this.aliasWhell = aliasWhell;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDetectLanguage() {
        return detectLanguage;
    }

    public void setDetectLanguage(String detectLanguage) {
        this.detectLanguage = detectLanguage;
    }

    public Object getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Object updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public GetThumb getGetThumb() {
        return getThumb;
    }

    public void setGetThumb(GetThumb getThumb) {
        this.getThumb = getThumb;
    }

    public UserInfo_ getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo_ userInfo) {
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

    public List<Evaluation> getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(List<Evaluation> evaluation) {
        this.evaluation = evaluation;
    }

}
