package com.example.pc.footscore.Models.EmerFixture;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pc on 11/06/2018.
 */

public class Result_____ {

    @SerializedName("goalsHomeTeam")
    @Expose
    private Integer goalsHomeTeam;
    @SerializedName("goalsAwayTeam")
    @Expose
    private Integer goalsAwayTeam;
    @SerializedName("halfTime")
    @Expose
    private HalfTime____ halfTime;
    @SerializedName("extraTime")
    @Expose
    private ExtraTime_ extraTime;
    @SerializedName("penaltyShootout")
    @Expose
    private PenaltyShootout_ penaltyShootout;

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

    public HalfTime____ getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(HalfTime____ halfTime) {
        this.halfTime = halfTime;
    }

    public ExtraTime_ getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(ExtraTime_ extraTime) {
        this.extraTime = extraTime;
    }

    public PenaltyShootout_ getPenaltyShootout() {
        return penaltyShootout;
    }

    public void setPenaltyShootout(PenaltyShootout_ penaltyShootout) {
        this.penaltyShootout = penaltyShootout;
    }
}
