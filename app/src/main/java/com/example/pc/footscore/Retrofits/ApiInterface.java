package com.example.pc.footscore.Retrofits;


import com.example.pc.footscore.Models.CompetitionModele.Competition;
import com.example.pc.footscore.Models.FixturesModele.Fixtures;
import com.example.pc.footscore.Models.LeagueTableModele.LeagueTable;
import com.example.pc.footscore.Models.PlayersModele.Players;
import com.example.pc.footscore.Models.TeamFixModele.TeamFix;
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

    @GET("{link}")
    Call<LeagueTable> getLeagueTable(@Path("link") String link);

    @GET("{link}" )
    Call<Fixtures> getAllFixtures(@Path ("link") String link);

    @GET("{link}")
    Call<Players> getAllPlayers(@Path("link") String Link);

    @GET("fixtures")
    Call<Today> getAllMatchs();

    @GET("{link}")
    Call<TeamFix> getAllFutureFixtures(@Path("link") String Link,@Query("venue") String venue);


}
