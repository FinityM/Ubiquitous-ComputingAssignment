package com.example.rsswebreader;

public class RSSData {
    String title;
    String link;
    String image;

    public RSSData(String title, String link, String image) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getImage() {
        return image;
    }
}
