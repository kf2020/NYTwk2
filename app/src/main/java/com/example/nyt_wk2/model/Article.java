package com.example.nyt_wk2.model;

import com.google.gson.annotations.SerializedName;

/***
 * Model class for news articles. This should be 100% familiar to you.
 */
public class Article {
    public long id;
    public String title;
    public String byline;

    @SerializedName("abstract")
    public String _abstract;

    public String url;

    @SerializedName("published_date")
    public String publishedDate;
    public Media[] media;

    public Article(long id, String title, String byline, String _abstract,
                   String url, String publishedDate, Media[] media) {
        this.id = id;
        this.title = title;
        this.byline = byline;
        this._abstract = _abstract;
        this.url = url;
        this.publishedDate = publishedDate;
        this.media = media;
    }

    public String getThumbnailUrl() {
        return media[0].mediaMetadata[0].getUrl();
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void set_abstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String get_abstract() {
        return _abstract;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getByline() {
        return byline;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPublishedDate(String published_date) {
        this.publishedDate = published_date;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}