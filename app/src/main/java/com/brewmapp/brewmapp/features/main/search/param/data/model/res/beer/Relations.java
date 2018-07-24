
package com.brewmapp.brewmapp.features.main.search.param.data.model.res.beer;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Relations {

    @SerializedName("BeerBrand")
    @Expose
    private BeerBrand beerBrand;
    @SerializedName("BeerStrength")
    @Expose
    private BeerStrength beerStrength;
    @SerializedName("Country")
    @Expose
    private Country country;
    @SerializedName("BeerType")
    @Expose
    private BeerType beerType;
    @SerializedName("Brewery")
    @Expose
    private Brewery brewery;
    @SerializedName("User")
    @Expose
    private User user;
    @SerializedName("ProductDensity")
    @Expose
    private ProductDensity productDensity;
    @SerializedName("BeerColor")
    @Expose
    private List<BeerColor> beerColor = null;
    @SerializedName("BeerFragrance")
    @Expose
    private List<BeerFragrance> beerFragrance = null;
    @SerializedName("BeerTaste")
    @Expose
    private List<BeerTaste> beerTaste = null;
    @SerializedName("BeerAftertaste")
    @Expose
    private List<BeerAftertaste> beerAftertaste = null;
    @SerializedName("BeerAveragePrice")
    @Expose
    private List<BeerAveragePrice> beerAveragePrice = null;
    @SerializedName("BeerToColors")
    @Expose
    private List<BeerToColor> beerToColors = null;
    @SerializedName("BeerToFragrances")
    @Expose
    private List<BeerToFragrance> beerToFragrances = null;
    @SerializedName("BeerToAftertastes")
    @Expose
    private List<BeerToAftertaste> beerToAftertastes = null;
    @SerializedName("BeerToTastes")
    @Expose
    private List<BeerToTaste> beerToTastes = null;
    @SerializedName("RestoMenu")
    @Expose
    private List<RestoMenu> restoMenu = null;

    public BeerBrand getBeerBrand() {
        return beerBrand;
    }

    public void setBeerBrand(BeerBrand beerBrand) {
        this.beerBrand = beerBrand;
    }

    public BeerStrength getBeerStrength() {
        return beerStrength;
    }

    public void setBeerStrength(BeerStrength beerStrength) {
        this.beerStrength = beerStrength;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public BeerType getBeerType() {
        return beerType;
    }

    public void setBeerType(BeerType beerType) {
        this.beerType = beerType;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProductDensity getProductDensity() {
        return productDensity;
    }

    public void setProductDensity(ProductDensity productDensity) {
        this.productDensity = productDensity;
    }

    public List<BeerColor> getBeerColor() {
        return beerColor;
    }

    public void setBeerColor(List<BeerColor> beerColor) {
        this.beerColor = beerColor;
    }

    public List<BeerFragrance> getBeerFragrance() {
        return beerFragrance;
    }

    public void setBeerFragrance(List<BeerFragrance> beerFragrance) {
        this.beerFragrance = beerFragrance;
    }

    public List<BeerTaste> getBeerTaste() {
        return beerTaste;
    }

    public void setBeerTaste(List<BeerTaste> beerTaste) {
        this.beerTaste = beerTaste;
    }

    public List<BeerAftertaste> getBeerAftertaste() {
        return beerAftertaste;
    }

    public void setBeerAftertaste(List<BeerAftertaste> beerAftertaste) {
        this.beerAftertaste = beerAftertaste;
    }

    public List<BeerAveragePrice> getBeerAveragePrice() {
        return beerAveragePrice;
    }

    public void setBeerAveragePrice(List<BeerAveragePrice> beerAveragePrice) {
        this.beerAveragePrice = beerAveragePrice;
    }

    public List<BeerToColor> getBeerToColors() {
        return beerToColors;
    }

    public void setBeerToColors(List<BeerToColor> beerToColors) {
        this.beerToColors = beerToColors;
    }

    public List<BeerToFragrance> getBeerToFragrances() {
        return beerToFragrances;
    }

    public void setBeerToFragrances(List<BeerToFragrance> beerToFragrances) {
        this.beerToFragrances = beerToFragrances;
    }

    public List<BeerToAftertaste> getBeerToAftertastes() {
        return beerToAftertastes;
    }

    public void setBeerToAftertastes(List<BeerToAftertaste> beerToAftertastes) {
        this.beerToAftertastes = beerToAftertastes;
    }

    public List<BeerToTaste> getBeerToTastes() {
        return beerToTastes;
    }

    public void setBeerToTastes(List<BeerToTaste> beerToTastes) {
        this.beerToTastes = beerToTastes;
    }

    public List<RestoMenu> getRestoMenu() {
        return restoMenu;
    }

    public void setRestoMenu(List<RestoMenu> restoMenu) {
        this.restoMenu = restoMenu;
    }

}
