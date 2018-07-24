
package com.brewmapp.brewmapp.features.main.search.param.data.model.res.beer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeerType {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private Name__ name;
    @SerializedName("name_wheel")
    @Expose
    private String nameWheel;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("parent_id")
    @Expose
    private Object parentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name__ getName() {
        return name;
    }

    public void setName(Name__ name) {
        this.name = name;
    }

    public String getNameWheel() {
        return nameWheel;
    }

    public void setNameWheel(String nameWheel) {
        this.nameWheel = nameWheel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

}
