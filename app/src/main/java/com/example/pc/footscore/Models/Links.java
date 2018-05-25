package com.example.pc.footscore.Models;

import com.example.pc.footscore.Models.TeamsModele.Team;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pc on 25/05/2018.
 */

public class Links {
    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("team")
    @Expose
    private Team team;

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
