package com.example.pc.footscore.Views;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pc.footscore.R;
import com.example.pc.footscore.Retrofits.ApiClient;
import com.example.pc.footscore.Retrofits.ApiInterface;

import retrofit2.Retrofit;

public class Head2head1ctivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView rv;
    private ApiInterface cmp;

    private SwipeRefreshLayout spr;
    ApiClient configRetro = new ApiClient();
    Retrofit retrofit = configRetro.getClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page);
        rv= (RecyclerView)findViewById(R.id.list);
        spr= (SwipeRefreshLayout)findViewById(R.id.swipe);
        rv.setLayoutManager(new LinearLayoutManager(this));
        getHeads();

    }

    private void getHeads() {


    }

    @Override
    public void onRefresh() {

    }
}
