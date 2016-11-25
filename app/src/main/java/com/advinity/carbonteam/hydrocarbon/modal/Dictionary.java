package com.advinity.carbonteam.hydrocarbon.modal;

/**
 * Created by afdolash on 25/11/16.
 */

public class Dictionary {
    private String title, content;

    public Dictionary(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
