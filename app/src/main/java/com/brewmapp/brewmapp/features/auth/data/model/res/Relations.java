
package com.brewmapp.brewmapp.features.auth.data.model.res;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Relations {

    @SerializedName("Country")
    @Expose
    private Country country;
    @SerializedName("City")
    @Expose
    private City city;
    @SerializedName("UserSocial")
    @Expose
    private List<UserSocial> userSocial = null;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<UserSocial> getUserSocial() {
        return userSocial;
    }

    public void setUserSocial(List<UserSocial> userSocial) {
        this.userSocial = userSocial;
    }

}
