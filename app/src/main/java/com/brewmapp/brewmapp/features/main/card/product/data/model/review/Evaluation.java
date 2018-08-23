
package com.brewmapp.brewmapp.features.main.card.product.data.model.review;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Evaluation {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("product_model")
    @Expose
    private String productModel;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("evaluation_type")
    @Expose
    private String evaluationType;
    @SerializedName("evaluation_value")
    @Expose
    private String evaluationValue;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    public String getEvaluationValue() {
        return evaluationValue;
    }

    public void setEvaluationValue(String evaluationValue) {
        this.evaluationValue = evaluationValue;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
