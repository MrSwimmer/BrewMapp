
package com.brewmapp.brewmapp.features.auth.data.model.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Counts {

    @SerializedName("PhotoAlbum")
    @Expose
    private Integer photoAlbum;
    @SerializedName("Subscription")
    @Expose
    private Integer subscription;
    @SerializedName("UserWorkPlaces")
    @Expose
    private Integer userWorkPlaces;
    @SerializedName("UserFriends")
    @Expose
    private Integer userFriends;
    @SerializedName("SignedAtUser")
    @Expose
    private Integer signedAtUser;
    @SerializedName("RestoUserAdmin")
    @Expose
    private Integer restoUserAdmin;
    @SerializedName("BreweryUserAdmin")
    @Expose
    private Integer breweryUserAdmin;

    public Integer getPhotoAlbum() {
        return photoAlbum;
    }

    public void setPhotoAlbum(Integer photoAlbum) {
        this.photoAlbum = photoAlbum;
    }

    public Integer getSubscription() {
        return subscription;
    }

    public void setSubscription(Integer subscription) {
        this.subscription = subscription;
    }

    public Integer getUserWorkPlaces() {
        return userWorkPlaces;
    }

    public void setUserWorkPlaces(Integer userWorkPlaces) {
        this.userWorkPlaces = userWorkPlaces;
    }

    public Integer getUserFriends() {
        return userFriends;
    }

    public void setUserFriends(Integer userFriends) {
        this.userFriends = userFriends;
    }

    public Integer getSignedAtUser() {
        return signedAtUser;
    }

    public void setSignedAtUser(Integer signedAtUser) {
        this.signedAtUser = signedAtUser;
    }

    public Integer getRestoUserAdmin() {
        return restoUserAdmin;
    }

    public void setRestoUserAdmin(Integer restoUserAdmin) {
        this.restoUserAdmin = restoUserAdmin;
    }

    public Integer getBreweryUserAdmin() {
        return breweryUserAdmin;
    }

    public void setBreweryUserAdmin(Integer breweryUserAdmin) {
        this.breweryUserAdmin = breweryUserAdmin;
    }

}
