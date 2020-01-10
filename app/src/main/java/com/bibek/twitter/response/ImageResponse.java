package com.bibek.twitter.response;

public class ImageResponse {
    private  String fileName;

    public ImageResponse(String fileName) {
        this.fileName = fileName;
    }

    public String getFilename() {
        return fileName;
    }

    public void setFilename(String fileName) {
        this.fileName = fileName;
    }
}
