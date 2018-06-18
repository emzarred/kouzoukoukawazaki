package com.example.pc.footscore.Models.EmerFixture;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pc on 11/06/2018.
 */

class LastAwayWinAwayTeam {
   /* @SerializedName("_links")
    @Expose
    private Links___ links;*/
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("matchday")
    @Expose
    private Integer matchday;
    @SerializedName("homeTeamName")
    @Expose
    private String homeTeamName;
    @SerializedName("awayTeamName")
    @Expose
    private String awayTeamName;
    @SerializedName("result")
    @Expose
    private Result___ result;
    @SerializedName("odds")
    @Expose
    private Object odds;

   /* public Links___ getLinks() {
        return links;
    }

    public void setLinks(Links___ links) {
        this.links = links;
    }*/

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public Result___ getResult() {
        return result;
    }

    public void setResult(Result___ result) {
        this.result = result;
    }

    public Object getOdds() {
        return odds;
    }

    public void setOdds(Object odds) {
        this.odds = odds;
    }

}
