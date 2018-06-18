package com.example.pc.footscore.Adapters;


import android.content.Context;
import android.content.SharedPreferences;
import android.view.SurfaceView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.pc.footscore.Models.FixturesModele.Fixture;
import com.example.pc.footscore.R;


import java.util.List;
/**
 * Created by pc on 07/05/2018.
 */

public class TodayAdapter extends RecyclerView.Adapter {
    private List<Fixture> list;
    public static String date, home, score, away;
    private Context mContext;
    SharedPreferences sharedPreferences;
    public TodayAdapter(List<Fixture> list) {
        this.list = list;

        }
        //this.listR=listR;



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.day_cell, parent, false);
        return new TodayAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Fixture fixture = list.get(position);
       // String c = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        //String c =MainActivity.date;
//if((fixture.getDate().substring(0,Math.min(fixture.getDate().length(),10)).equals(c)   )){
        TodayAdapter.ViewHolder.TvDate.setText(fixture.getDate().substring(11,19));
        TodayAdapter.ViewHolder.TvHome.setText(fixture.getHomeTeamName());
        if((fixture.getResult().getGoalsAwayTeam()==null) &&(fixture.getResult().getGoalsHomeTeam()==null)){
        TodayAdapter.ViewHolder.TvScore.setText( fixture.getStatus());}
        else{
            ViewHolder.TvScore.setText(fixture.getResult().getGoalsHomeTeam()+"-"+fixture.getResult().getGoalsAwayTeam());
        }
        TodayAdapter.ViewHolder.TvAway.setText(fixture.getAwayTeamName());
       /*else{
        ViewHolder.TvDate.setVisibility(View.GONE);
    ViewHolder.TvHome.setVisibility(View.GONE);
    ViewHolder.TvScore.setVisibility(View.GONE);
    ViewHolder.TvAway.setVisibility(View.GONE);
    ViewHolder.check.setVisibility(View.GONE);
    ViewHolder.devider.setVisibility(GONE);}*/
        date= (String) ViewHolder.TvDate.getText();
        home= (String) ViewHolder.TvHome.getText();
        score= (String) ViewHolder.TvScore.getText();
        away= (String) ViewHolder.TvAway.getText();
    ViewHolder.check.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(ViewHolder.check.isChecked()){
            SharedPreferences sharedPreferences = mContext.getSharedPreferences("data",mContext.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("date",date);
            editor.putString("home",home );
            editor.putString("score",score);
            editor.putString("away",away);
            editor.apply();

        }

    }
});




    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        static TextView TvDate, TvHome, TvAway, TvScore;
        static CheckBox check;
        static SurfaceView devider;
        public ViewHolder(View v) {
            super(v);

            TvDate = (TextView) v.findViewById(R.id.TvDate);
            TvHome = (TextView) v.findViewById(R.id.TvHome);
            TvScore = (TextView) v.findViewById(R.id.TvScore);
            TvAway = (TextView) v.findViewById(R.id.TvAway);
            check = (CheckBox) v.findViewById(R.id.checkBox);
            devider=(SurfaceView)v.findViewById(R.id.devider);
        }
    }
}
