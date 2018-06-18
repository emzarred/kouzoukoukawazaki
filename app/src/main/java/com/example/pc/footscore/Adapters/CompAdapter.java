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


    /* this is the public listener that you set from the outside of the adapter */
    public static List<Competition> list;

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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        holder.getAdapterPosition();
        holder.setIsRecyclable(false);


        final Competition competition=list.get(position);
        CompAdapter.ViewHolder.caption.setText(competition.getCaption() + "(" + String.valueOf(competition.getCurrentMatchday()) + "/" + String.valueOf(competition.getNumberOfMatchdays()) + ")");
        ViewHolder.caption.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                try{
                Links link=competition.getLinks();
                String hrefE=link.getTeams().getHref();
                newHrefE=hrefE.substring(32, 54);


                String hrefC=link.getLeagueTable().getHref();
                newHrefC=hrefC.substring(32, 60);

                String hrefF=link.getFixtures().getHref();
                newHrefF=hrefF.substring(32, 57);
                // href=competition.getLinks().getTeams().getHref().substring(24, 22);
                Toast.makeText(ViewHolder.caption.getContext(), "cc "+newHrefE, Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(ViewHolder.caption.getContext(), DetailActivity.class);
                ViewHolder.caption.getContext().startActivity(intent);}
                catch (Exception e) {
                    Toast.makeText(ViewHolder.caption.getContext(), "there are not available informations", Toast.LENGTH_SHORT).show();
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

    public static class ViewHolder extends RecyclerView.ViewHolder  {

        static TextView caption;


        public ViewHolder(View v) {
            super(v);

            caption=(TextView) v.findViewById(R.id.TvCap);

        }













    }


            }
