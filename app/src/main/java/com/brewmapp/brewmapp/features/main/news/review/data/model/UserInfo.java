
package com.brewmapp.brewmapp.features.main.news.review.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private Object lastname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("fb")
    @Expose
    private Object fb;
    @SerializedName("fb_access_token")
    @Expose
    private Object fbAccessToken;
    @SerializedName("fb_expires")
    @Expose
    private Object fbExpires;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("password")
    @Expose
    private Object password;
    @SerializedName("country_id")
    @Expose
    private Object countryId;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("city_id")
    @Expose
    private Object cityId;
    @SerializedName("birthday")
    @Expose
    private Object birthday;
    @SerializedName("family_status")
    @Expose
    private Object familyStatus;
    @SerializedName("mob_phone")
    @Expose
    private Object mobPhone;
    @SerializedName("addit_phone")
    @Expose
    private Object additPhone;
    @SerializedName("skype")
    @Expose
    private Object skype;
    @SerializedName("site")
    @Expose
    private Object site;
    @SerializedName("job")
    @Expose
    private Object job;
    @SerializedName("interests")
    @Expose
    private Object interests;
    @SerializedName("music")
    @Expose
    private Object music;
    @SerializedName("films")
    @Expose
    private Object films;
    @SerializedName("books")
    @Expose
    private Object books;
    @SerializedName("games")
    @Expose
    private Object games;
    @SerializedName("about")
    @Expose
    private Object about;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;
    @SerializedName("is_bot")
    @Expose
    private Object isBot;
    @SerializedName("additional_data")
    @Expose
    private String additionalData;
    @SerializedName("advertising")
    @Expose
    private String advertising;
    @SerializedName("city_name")
    @Expose
    private Object cityName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Object getLastname() {
        return lastname;
    }

    public void setLastname(Object lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getFb() {
        return fb;
    }

    public void setFb(Object fb) {
        this.fb = fb;
    }

    public Object getFbAccessToken() {
        return fbAccessToken;
    }

    public void setFbAccessToken(Object fbAccessToken) {
        this.fbAccessToken = fbAccessToken;
    }

    public Object getFbExpires() {
        return fbExpires;
    }

    public void setFbExpires(Object fbExpires) {
        this.fbExpires = fbExpires;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public Object getCountryId() {
        return countryId;
    }

    public void setCountryId(Object countryId) {
        this.countryId = countryId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Object getCityId() {
        return cityId;
    }

    public void setCityId(Object cityId) {
        this.cityId = cityId;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public Object getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(Object familyStatus) {
        this.familyStatus = familyStatus;
    }

    public Object getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(Object mobPhone) {
        this.mobPhone = mobPhone;
    }

    public Object getAdditPhone() {
        return additPhone;
    }

    public void setAdditPhone(Object additPhone) {
        this.additPhone = additPhone;
    }

    public Object getSkype() {
        return skype;
    }

    public void setSkype(Object skype) {
        this.skype = skype;
    }

    public Object getSite() {
        return site;
    }

    public void setSite(Object site) {
        this.site = site;
    }

    public Object getJob() {
        return job;
    }

    public void setJob(Object job) {
        this.job = job;
    }

    public Object getInterests() {
        return interests;
    }

    public void setInterests(Object interests) {
        this.interests = interests;
    }

    public Object getMusic() {
        return music;
    }

    public void setMusic(Object music) {
        this.music = music;
    }

    public Object getFilms() {
        return films;
    }

    public void setFilms(Object films) {
        this.films = films;
    }

    public Object getBooks() {
        return books;
    }

    public void setBooks(Object books) {
        this.books = books;
    }

    public Object getGames() {
        return games;
    }

    public void setGames(Object games) {
        this.games = games;
    }

    public Object getAbout() {
        return about;
    }

    public void setAbout(Object about) {
        this.about = about;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Object getIsBot() {
        return isBot;
    }

    public void setIsBot(Object isBot) {
        this.isBot = isBot;
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

    public Object getCityName() {
        return cityName;
    }

    public void setCityName(Object cityName) {
        this.cityName = cityName;
    }

}
