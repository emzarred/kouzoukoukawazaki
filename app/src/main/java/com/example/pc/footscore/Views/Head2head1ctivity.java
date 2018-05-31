package com.example.pc.footscore.Views;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.Toast;

import com.example.pc.footscore.Adapters.HeadsAdapter;
import com.example.pc.footscore.Models.Head2Head.Head2head;
import com.example.pc.footscore.R;
import com.example.pc.footscore.Retrofits.ApiClient;
import com.example.pc.footscore.Retrofits.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class Head2head1ctivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView rv;
    private ApiInterface cmp;
    private Context context;

    private SwipeRefreshLayout spr;
    ApiClient configRetro = new ApiClient();
    Retrofit retrofit = configRetro.getClient();
    private List <Head2head>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page);
        rv= (RecyclerView)findViewById(R.id.list);
        spr= (SwipeRefreshLayout)findViewById(R.id.swipe);
        rv.setLayoutManager(new LinearLayoutManager(this));

        getHeads();

    }
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {

            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {



            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    private void getHeads() {
        final ApiInterface cmp = retrofit.create(ApiInterface.class);
        Call<Head2head> call = cmp.getAllHeads();
        call.enqueue(new Callback<Head2head>() {
            @Override
            public void onResponse(Call<Head2head> call, Response<Head2head> response) {
                List<Head2head> list = (List<Head2head>) response.body();
                rv.setAdapter(new HeadsAdapter(list));

            }

            @Override
            public void onFailure(Call<Head2head> call, Throwable t) {
                Toast.makeText(context,"connection failed",Toast.LENGTH_LONG).show();

            }





        });


    }

    @Override
    public void onRefresh() {

    }
}
