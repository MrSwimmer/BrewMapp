
package com.brewmapp.brewmapp.features.main.search.result.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("text")
    @Expose
    private Text text;
    @SerializedName("avg_ball")
    @Expose
    private String avgBall;
    @SerializedName("getThumb")
    @Expose
    private GetThumb getThumb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public String getAvgBall() {
        return avgBall;
    }

    public void setAvgBall(String avgBall) {
        this.avgBall = avgBall;
    }

    public GetThumb getGetThumb() {
        return getThumb;
    }

    public void setGetThumb(GetThumb getThumb) {
        this.getThumb = getThumb;
    }

}
