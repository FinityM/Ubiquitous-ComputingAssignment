package com.example.rsswebreader;

public class RSSData {
    String title;
    String link;
    String description;
    String pubDate;
    String image;

    public RSSData(String title, String link, String description, String pubDate, String image) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
        this.image = image;
    }
}
