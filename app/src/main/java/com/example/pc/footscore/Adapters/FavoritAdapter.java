package com.example.pc.footscore.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.pc.footscore.Models.FixturesModele.Fixture;
import com.example.pc.footscore.R;

import java.util.List;

import static android.support.constraint.solver.widgets.ConstraintWidget.GONE;
import static com.example.pc.footscore.Adapters.FavoritAdapter.ViewHolder.TvAway;
import static com.example.pc.footscore.Adapters.FavoritAdapter.ViewHolder.TvDate;
import static com.example.pc.footscore.Adapters.FavoritAdapter.ViewHolder.TvHome;
import static com.example.pc.footscore.Adapters.FavoritAdapter.ViewHolder.TvScore;
import static com.example.pc.footscore.Adapters.FavoritAdapter.ViewHolder.check;
import static com.example.pc.footscore.Adapters.FavoritAdapter.ViewHolder.devider;
import static com.example.pc.footscore.Adapters.FavoritAdapter.ViewHolder.msg;

/**
 * Created by pc on 31/05/2018.
 */

public class FavoritAdapter extends RecyclerView.Adapter {
    SharedPreferences sharedPreferences;


    public static String date, home, score, away;
    private Context mContext;
private List<Fixture>data;
    public FavoritAdapter( List <Fixture> data)

    {

        this.data = data;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

SharedPreferences pref=mContext.getSharedPreferences("data",mContext.MODE_PRIVATE);
        date = pref.getString("date", "");
        home = pref.getString("home", "");
        score = pref.getString("score", "");
        away = pref.getString("away", "");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.day_cell, parent, false);

        return new TodayAdapter.ViewHolder(view);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Fixture fixture = data.get(position);


        TvDate.setText(fixture.getDate());
        TvHome.setText(fixture.getHomeTeamName());
        TvScore.setText(fixture.getStatus());
        TvAway.setText((CharSequence) fixture.getAwayTeamName());
        if (!check.isChecked() ) {
            TvDate.setVisibility(View.GONE);
            TvHome.setVisibility(View.GONE);
            TvScore.setVisibility(View.GONE);
            TvAway.setVisibility(View.GONE);
            check.setVisibility(View.GONE);
            devider.setVisibility(GONE);

            msg.setText("No Matches Selected");
        }

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
        return data.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        static TextView TvDate, TvHome, TvAway, TvScore;
        static CheckBox check;
        static View devider;
        static TextView msg;


        public ViewHolder(View v) {
            super(v);
            TvDate = (TextView) v.findViewById(R.id.TvDate);
            TvHome = (TextView) v.findViewById(R.id.TvHome);
            TvScore = (TextView) v.findViewById(R.id.TvScore);
            TvAway = (TextView) v.findViewById(R.id.TvAway);
            check = (CheckBox) v.findViewById(R.id.checkBox);
            devider = (View) v.findViewById(R.id.devider);
            msg = (TextView) v.findViewById(R.id.msg);
        }
    }
}
