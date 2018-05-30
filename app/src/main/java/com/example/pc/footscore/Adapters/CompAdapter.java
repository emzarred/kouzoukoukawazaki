package com.example.pc.footscore.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.footscore.Models.CompetitionModele.Competition;
import com.example.pc.footscore.Models.CompetitionModele.Links;
import com.example.pc.footscore.Models.CompetitionModele.Teams;
import com.example.pc.footscore.R;
import com.example.pc.footscore.Views.DetailActivity;


import java.util.List;

/**
 * Created by pc on 25/04/2018.
 */


public class CompAdapter extends RecyclerView.Adapter {
    public static List<Competition> list;
    public static int Id;
    public static String newHrefE, newHrefC, newHrefF;
    public static String hrefE, hrefC, hrefF;


    public CompAdapter(List<Competition> list) {
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.comp_cell, parent, false);
        return new CompAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        final Competition competition=list.get(position);
        holder.setIsRecyclable(false);

        CompAdapter.ViewHolder.caption.setText(competition.getCaption() + "(" + String.valueOf(competition.getCurrentMatchday()) + "/" + String.valueOf(competition.getNumberOfMatchdays()) + ")");
        ViewHolder.caption.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               /* holder.getAdapterPosition();
                holder.setIsRecyclable(false);*/
                Links link=competition.getLinks();
                String hrefE=link.getTeams().getHref();
                newHrefE=hrefE.substring(32, 54);


                String hrefC=link.getLeagueTable().getHref();
                newHrefC=hrefC.substring(32, 60);

                String hrefF=link.getFixtures().getHref();
                newHrefF=hrefF.substring(32, 57);
                // href=competition.getLinks().getTeams().getHref().substring(24, 22);
                //Toast.makeText(ViewHolder.caption.getContext(), "cc "+href, Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(ViewHolder.caption.getContext(), DetailActivity.class);
                ViewHolder.caption.getContext().startActivity(intent);
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

        static TextView caption;

        public ViewHolder(View v) {
            super(v);

            caption=(TextView) v.findViewById(R.id.TvCap);


        }

    }


}
