package com.example.pc.footscore.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.footscore.Adapters.CompAdapter;
import com.example.pc.footscore.Models.CompetitionModele.Competition;
import com.example.pc.footscore.Models.EmerFixture.FixtureD;
import com.example.pc.footscore.Models.EmerFixture.Fixture_;
import com.example.pc.footscore.Models.EmerFixture.Head2head;
import com.example.pc.footscore.R;
import com.example.pc.footscore.Retrofits.ApiClient;
import com.example.pc.footscore.Retrofits.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.widget.Toast.makeText;

public class Head2headActivity extends AppCompatActivity {
    ApiClient configRetro = new ApiClient();
    Retrofit retrofit = configRetro.getClient();
    private TextView Tv7,Tv8;

    List<Competition> list;
    private ApiInterface cmp;
    private RecyclerView rv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page);
        rv7 = (RecyclerView) findViewById(R.id.list);
        rv7.setLayoutManager(new LinearLayoutManager(this));
        getHeads();
    }

    private void getHeads() {
        final ApiInterface cmp = retrofit.create(ApiInterface.class);
        Call<Head2head> call = cmp.getAllHeads();
        call.enqueue(new Callback<Head2head>() {
            @Override
            public void onResponse(Call<Head2head> call, Response<Head2head> response) {

                List<Fixture_> list = (List<Fixture_>) response.body().getFixtures();
                rv7.setAdapter(new HeadAdapter(list));


            }

            @Override
            public void onFailure(Call<Head2head> call, Throwable t) {

                //Toast.makeText(this,"connection faild try again!",Toast.LENGTH_SHORT).show();
            }


        });

    }
}
