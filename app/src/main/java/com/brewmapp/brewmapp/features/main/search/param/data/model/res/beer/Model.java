
package com.brewmapp.brewmapp.features.main.search.param.data.model.res.beer;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

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
    private Object productIbuId;
    @SerializedName("product_ibu")
    @Expose
    private String productIbu;
    @SerializedName("strength_id")
    @Expose
    private String strengthId;
    @SerializedName("brewery_id")
    @Expose
    private String breweryId;
    @SerializedName("capacity_id")
    @Expose
    private String capacityId;
    @SerializedName("pricerange_id")
    @Expose
    private String pricerangeId;
    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("title_ru")
    @Expose
    private String titleRu;
    @SerializedName("text")
    @Expose
    private Text text;
    @SerializedName("short_text")
    @Expose
    private ShortText shortText;
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
    private String updatedAt;
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
    private String getThumb;
    @SerializedName("getThumbOriginal")
    @Expose
    private String getThumbOriginal;
    @SerializedName("relations")
    @Expose
    private Relations relations;
    @SerializedName("counts")
    @Expose
    private Counts counts;
    @SerializedName("like")
    @Expose
    private String like;
    @SerializedName("dis_like")
    @Expose
    private String disLike;
    @SerializedName("avgPrices")
    @Expose
    private List<AvgPrice> avgPrices = null;

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

    public Object getProductIbuId() {
        return productIbuId;
    }

    public void setProductIbuId(Object productIbuId) {
        this.productIbuId = productIbuId;
    }

    public String getProductIbu() {
        return productIbu;
    }

    public void setProductIbu(String productIbu) {
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

    public String getCapacityId() {
        return capacityId;
    }

    public void setCapacityId(String capacityId) {
        this.capacityId = capacityId;
    }

    public String getPricerangeId() {
        return pricerangeId;
    }

    public void setPricerangeId(String pricerangeId) {
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

    public String getGetThumb() {
        return getThumb;
    }

    public void setGetThumb(String getThumb) {
        this.getThumb = getThumb;
    }

    public String getGetThumbOriginal() {
        return getThumbOriginal;
    }

    public void setGetThumbOriginal(String getThumbOriginal) {
        this.getThumbOriginal = getThumbOriginal;
    }

    public Relations getRelations() {
        return relations;
    }

    public void setRelations(Relations relations) {
        this.relations = relations;
    }

    public Counts getCounts() {
        return counts;
    }

    public void setCounts(Counts counts) {
        this.counts = counts;
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

    public List<AvgPrice> getAvgPrices() {
        return avgPrices;
    }

    public void setAvgPrices(List<AvgPrice> avgPrices) {
        this.avgPrices = avgPrices;
    }

}
