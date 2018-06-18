package com.example.pc.footscore.Models.EmerFixture;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pc on 11/06/2018.
 */

class Result_ {
    @SerializedName("goalsHomeTeam")
    @Expose
    private Integer goalsHomeTeam;
    @SerializedName("goalsAwayTeam")
    @Expose
    private Integer goalsAwayTeam;
    @SerializedName("halfTime")
    @Expose
    private HalfTime_ halfTime;

    public Integer getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(Integer goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public Integer getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(Integer goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public HalfTime_ getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(HalfTime_ halfTime) {
        this.halfTime = halfTime;
    }
}
