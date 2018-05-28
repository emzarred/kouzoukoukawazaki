package com.example.pc.footscore.Retrofits;


import com.example.pc.footscore.Models.CompetitionModele.Competition;
import com.example.pc.footscore.Models.Fixtures;
import com.example.pc.footscore.Models.LeagueTable;
import com.example.pc.footscore.Models.Players;
import com.example.pc.footscore.Models.TeamFix;
import com.example.pc.footscore.Models.TeamsModele.Teams;
import com.example.pc.footscore.Models.Today;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pc on 25/04/2018.
 */

public interface ApiInterface {
    @GET("competitions/")
    Call<List<Competition>> getAllCompetitions(@Query("season") Integer year);

   /*@GET("competitions/{Id}/teams")
    Call<Teams> getAllTeams(@Path ("Id") Integer Id);*/
   @GET("{link}")
   Call<Teams> getAllTeams(@Path ("link") String link);

    @GET("competitions/{Id}/leagueTable")
    Call<LeagueTable> getLeagueTable(@Path("Id") Integer Id);

    @GET("competitions/{Id}/fixtures" )
    Call<Fixtures> getAllFixtures(@Path ("Id") Integer Id);

    @GET("{link}")
    Call<Players> getAllPlayers(@Path("link") String Link);

    @GET("fixtures")
    Call<Today> getAllMatchs();

    @GET("teams/66/fixtures/?season=2016")
    Call<TeamFix> getAllFutureFixtures(@Query("venue") String venue);


}
