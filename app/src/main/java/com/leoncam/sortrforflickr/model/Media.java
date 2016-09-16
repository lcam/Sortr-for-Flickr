package com.leoncam.sortrforflickr.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Plain Old Java Object (POJO) for "media" JSON data from Flickr API.
public class Media {

    @SerializedName("m")
    @Expose
    private String m;

    /**
     *
     * @return
     * The m
     */
    public String getM() {
        return m;
    }

    /**
     *
     * @param m
     * The m
     */
    public void setM(String m) {
        this.m = m;
    }

}
