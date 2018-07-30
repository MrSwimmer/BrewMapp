
package com.brewmapp.brewmapp.features.main.search.result.data.model.beer;

import java.util.HashMap;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private HashMap<String, String> title;
    @Expose
    private HashMap<String, String> text;
    @SerializedName("avg_ball")
    @Expose
    private String avgBall;
    @SerializedName("getThumb")
    @Expose
    private String getThumb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, String> getTitle() {
        return title;
    }

    public void setTitle(HashMap<String, String> title) {
        this.title = title;
    }

    public HashMap<String, String> getText() {
        return text;
    }

    public void setText(HashMap<String, String> text) {
        this.text = text;
    }

    public String getAvgBall() {
        return avgBall;
    }

    public String getGetThumb() {
        return getThumb;
    }
}
