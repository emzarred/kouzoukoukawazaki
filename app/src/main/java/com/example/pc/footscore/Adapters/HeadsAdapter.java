package com.example.pc.footscore.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.footscore.Controllers.Fragments.Head2HeadFragment;
import com.example.pc.footscore.Models.Head2Head.Head2head;
import com.example.pc.footscore.R;

import java.util.List;

/**
 * Created by pc on 30/05/2018.
 */

public class HeadsAdapter extends RecyclerView.Adapter {
private List <Head2head> list;
    public HeadsAdapter(List<Head2head> list) {
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.comp_cell, parent, false);
        return new HeadsAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        Head2head head =list.get(position);
        ViewHolder.caption.setText("home team wins: "+ head.getHomeTeamWins()+ "draws: "+ head.getDraws()+ "away team wins: "+ head.getAwayTeamWins() );


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

        static TextView caption;

        public ViewHolder(View v) {
            super(v);

            caption=(TextView) v.findViewById(R.id.TvCap);


        }

    }
}