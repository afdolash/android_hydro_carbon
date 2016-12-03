package com.advinity.carbonteam.hydrocarbon.modal;

/**
 * Created by afdolash on 02/12/16.
 */

public class Ebook {
    private String title;
    private String subtitle;
    private int thumbnail;

    public Ebook(String title, String subtitle, int thumbnail) {
        this.title = title;
        this.subtitle = subtitle;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
