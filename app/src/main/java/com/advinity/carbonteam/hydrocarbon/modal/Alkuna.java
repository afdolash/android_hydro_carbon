package com.advinity.carbonteam.hydrocarbon.modal;

/**
 * Created by afdolash on 24/11/16.
 */

public class Alkuna {
    private String title, subtitle, other;

    public Alkuna(String title, String subtitle, String other) {
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
