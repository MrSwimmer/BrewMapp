
package com.brewmapp.brewmapp.features.main.card.product.data.model.resto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("resto")
    @Expose
    private List<Resto_> resto = null;
    @SerializedName("news_count")
    @Expose
    private String newsCount;
    @SerializedName("review_count")
    @Expose
    private String reviewCount;
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
    @SerializedName("menu_count")
    @Expose
    private Integer menuCount;
    @SerializedName("resto_kitchen")
    @Expose
    private List<RestoKitchen> restoKitchen = null;
    @SerializedName("resto_feature")
    @Expose
    private List<RestoFeature> restoFeature = null;
    @SerializedName("resto_type")
    @Expose
    private List<RestoType> restoType = null;
    @SerializedName("resto_work_times")
    @Expose
    private List<RestoWorkTime> restoWorkTimes = null;
    @SerializedName("menu")
    @Expose
    private List<Menu> menu = null;

    public List<Resto_> getResto() {
        return resto;
    }

    public void setResto(List<Resto_> resto) {
        this.resto = resto;
    }

    public String getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(String newsCount) {
        this.newsCount = newsCount;
    }

    public String getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(String reviewCount) {
        this.reviewCount = reviewCount;
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

    public Integer getMenuCount() {
        return menuCount;
    }

    public void setMenuCount(Integer menuCount) {
        this.menuCount = menuCount;
    }

    public List<RestoKitchen> getRestoKitchen() {
        return restoKitchen;
    }

    public void setRestoKitchen(List<RestoKitchen> restoKitchen) {
        this.restoKitchen = restoKitchen;
    }

    public List<RestoFeature> getRestoFeature() {
        return restoFeature;
    }

    public void setRestoFeature(List<RestoFeature> restoFeature) {
        this.restoFeature = restoFeature;
    }

    public List<RestoType> getRestoType() {
        return restoType;
    }

    public void setRestoType(List<RestoType> restoType) {
        this.restoType = restoType;
    }

    public List<RestoWorkTime> getRestoWorkTimes() {
        return restoWorkTimes;
    }

    public void setRestoWorkTimes(List<RestoWorkTime> restoWorkTimes) {
        this.restoWorkTimes = restoWorkTimes;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

}
