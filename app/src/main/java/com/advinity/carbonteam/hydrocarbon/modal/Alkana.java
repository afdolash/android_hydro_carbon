package com.advinity.carbonteam.hydrocarbon.modal;

/**
 * Created by afdolash on 23/11/16.
 */

public class Alkana {
    private String title, subtitle, other;

    public Alkana(String title, String subtitle, String other) {
        this.title = title;
        this.subtitle = subtitle;
        this.other = other;
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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
