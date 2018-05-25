package com.example.pc.footscore.Models.TeamsModele;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pc on 25/05/2018.
 */

public class Links {
    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("competition")
    @Expose
    private Competition competition;

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
