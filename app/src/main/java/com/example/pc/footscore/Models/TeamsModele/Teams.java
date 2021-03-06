package com.example.pc.footscore.Models.TeamsModele;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pc on 27/04/2018.
 */

public class Teams {
    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("teams")
    @Expose
    private List<Team> teams = null;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
