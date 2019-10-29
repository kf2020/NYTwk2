package com.example.nyt_wk2.model;

import com.google.gson.annotations.SerializedName;

public class Media {
    @SerializedName("media-metadata")
    public MediaMetadata[] mediaMetadata;

    public Media(MediaMetadata[] mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }
}
