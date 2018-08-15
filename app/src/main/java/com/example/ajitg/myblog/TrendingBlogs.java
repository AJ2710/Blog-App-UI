package com.example.ajitg.myblog;

public class TrendingBlogs {

    public String header;
    public String subHeader;
    public int images;

    public TrendingBlogs(int images , String header, String subHeader) {

        this.images = images;
        this.header = header;
        this.subHeader = subHeader;

    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
