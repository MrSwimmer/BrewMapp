
package com.brewmapp.brewmapp.features.main.card.product.data.model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("code")
    @Expose
    private Object code;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
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
    private String gender;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("family_status")
    @Expose
    private String familyStatus;
    @SerializedName("mob_phone")
    @Expose
    private String mobPhone;
    @SerializedName("addit_phone")
    @Expose
    private String additPhone;
    @SerializedName("skype")
    @Expose
    private String skype;
    @SerializedName("site")
    @Expose
    private String site;
    @SerializedName("job")
    @Expose
    private String job;
    @SerializedName("interests")
    @Expose
    private String interests;
    @SerializedName("music")
    @Expose
    private String music;
    @SerializedName("films")
    @Expose
    private String films;
    @SerializedName("books")
    @Expose
    private String books;
    @SerializedName("games")
    @Expose
    private String games;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;
    @SerializedName("is_bot")
    @Expose
    private String isBot;
    @SerializedName("additional_data")
    @Expose
    private Object additionalData;
    @SerializedName("advertising")
    @Expose
    private String advertising;

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

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
    }

    public String getAdditPhone() {
        return additPhone;
    }

    public void setAdditPhone(String additPhone) {
        this.additPhone = additPhone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getFilms() {
        return films;
    }

    public void setFilms(String films) {
        this.films = films;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getIsBot() {
        return isBot;
    }

    public void setIsBot(String isBot) {
        this.isBot = isBot;
    }

    public Object getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Object additionalData) {
        this.additionalData = additionalData;
    }

    public String getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String advertising) {
        this.advertising = advertising;
    }

}
