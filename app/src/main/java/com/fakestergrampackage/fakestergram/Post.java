package com.fakestergrampackage.fakestergram;

public class Post {

    private String userHandle, date, imageUrl, geoTag;

    public Post(String userHandle, String date, String imageUrl, String geoTag) {
        this.userHandle = userHandle;
        this.date = date;
        this.imageUrl = imageUrl;
        this.geoTag = geoTag;
    }

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGeoTag() {
        return geoTag;
    }

    public void setGeoTag(String geoTag) {
        this.geoTag = geoTag;
    }
}
