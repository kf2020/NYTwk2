package com.example.nyt_wk2.model;

public class MediaMetadata {
    public String url;
    public String format;
    public double height;
    public double width;

    public MediaMetadata(String url, String format, double height, double width) {
        this.url = url;
        this.format = format;
        this.height = height;
        this.width = width;
    }

    public String getUrl() {
        return url;
    }
}
