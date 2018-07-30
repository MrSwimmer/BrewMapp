
package com.brewmapp.brewmapp.features.main.search.param.data.model.res.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("getThumb")
    @Expose
    private String getThumb;
    @SerializedName("getThumbOriginal")
    @Expose
    private String getThumbOriginal;
    @SerializedName("name_en")
    @Expose
    private String nameEn;

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
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

    public Model(String id, Name name, String getThumb) {
        this.id = id;
        this.name = name;
        this.getThumb = getThumb;
    }
}
