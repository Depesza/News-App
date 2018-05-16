package com.example.hania.news_app;

import java.util.Date;

public class News {
    private String mCategory;
    private String mAuthor;
    private String mTitle;
    private String mTime;
    private String mUrl;

    public News(String category, String author, String title, String time, String url){
        mCategory = category;
        mAuthor = author;
        mTitle = title;
        mTime = time;
        mUrl = url;
    }

    public String getCategory(){return mCategory;}

    public String getAuthor(){ return mAuthor;}

    public String getTitle(){return mTitle;}

    public String getTime(){ return mTime;}

    public String getUrl(){ return mUrl;}
}
