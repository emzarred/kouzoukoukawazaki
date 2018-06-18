package com.example.pc.footscore.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.ahmadrosid.svgloader.SvgLoader;
import com.example.pc.footscore.Models.TeamsModele.Links;
import com.example.pc.footscore.Models.TeamsModele.Links_;
import com.example.pc.footscore.Models.TeamsModele.Team;
import com.example.pc.footscore.R;

import com.example.pc.footscore.Views.TeamDetail;

import java.util.List;

/**
 * Created by pc on 26/04/2018.
 */

public class TeamAdapter extends RecyclerView.Adapter {
    public static String newHref;

    private List<Team>list;
public static Context context;
private ImageView flag;
private Activity activity;
public static String href;
public static String newHrefF;
    public TeamAdapter(List<Team> list, Context context, Activity activity) {
        this.list=list;
        this.context=context;
        this.activity=activity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.team_cell,parent,false);
        return new TeamAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final Team team = list.get(position);
        holder.getAdapterPosition();
        holder.setIsRecyclable(false);


if(!(team.getCrestUrl() ==null))
{

        SvgLoader.pluck()
                .with(activity)
                .setPlaceHolder(R.drawable.notfound,R.drawable.notfound)
                .load(team.getCrestUrl(), ViewHolder.flag);}
        ViewHolder.caption.setText(team.getName());
        holder.setIsRecyclable(false);
        ViewHolder.caption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                holder.getAdapterPosition();
                Links_ link=team.getLinks();
                String href=link.getPlayers().getHref();

                newHref = href.substring(32, 49);
                String hrefF=link.getFixtures().getHref();

                newHrefF=hrefF.substring(32,50);
               //Toast.makeText(ViewHolder.caption.getContext(), "link"+newHref,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ViewHolder.caption.getContext(),TeamDetail.class);
                ViewHolder.caption.getContext().startActivity(intent);}
                catch(Exception e ){
                    Toast.makeText(ViewHolder.caption.getContext(),"there are",Toast.LENGTH_SHORT);
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
static String test;
        static TextView caption;
        static ImageView flag;

        public ViewHolder(View v) {
            super(v);
            flag=(ImageView)v.findViewById(R.id.flag);
            caption = (TextView) v.findViewById(R.id.TvCap);



        }
    }

}




