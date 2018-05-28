package com.example.pc.footscore.Models.CompetitionModele;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pc on 28/05/2018.
 */

public class Teams {
    /*@SerializedName("href")
    @Expose*/
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
