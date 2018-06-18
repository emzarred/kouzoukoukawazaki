package com.example.pc.footscore.Views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.footscore.Adapters.FixturesAdapter;
import com.example.pc.footscore.Models.EmerFixture.Fixture_;
import com.example.pc.footscore.Models.EmerFixture.Head2head;
import com.example.pc.footscore.Models.FixturesModele.Fixture;
import com.example.pc.footscore.R;

import java.util.List;

/**
 * Created by pc on 11/06/2018.
 */

public class HeadAdapter extends RecyclerView.Adapter {
    private List<Fixture_> list;

    public HeadAdapter(List<Fixture_> list) {
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.fix_cell, parent, false);
        return new HeadAdapter.ViewHolder(view);
    }
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Fixture_ fixture = list.get(position);
        HeadAdapter.ViewHolder.TvDate.setText(fixture.getDate());
        HeadAdapter.ViewHolder.TvHome.setText(fixture.getHomeTeamName());
        HeadAdapter.ViewHolder.TvScore.setText(fixture.getResult().getGoalsHomeTeam() + " - " + fixture.getResult().getGoalsAwayTeam());
       HeadAdapter.ViewHolder.TvAway.setText(fixture.getAwayTeamName());
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


        public ViewHolder(View v) {
            super(v);

            TvDate=(TextView) v.findViewById(R.id.TvDate);
            TvHome=(TextView) v.findViewById(R.id.TvHome);
            TvScore=(TextView) v.findViewById(R.id.TvScore);
            TvAway=(TextView) v.findViewById(R.id.TvAway);


        }
    }
}