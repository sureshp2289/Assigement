package assigment.example.com.assignment.feeds;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import assigment.example.com.assignment.R;
import assigment.example.com.assignment.adapter.FeedAdapter;
import assigment.example.com.assignment.apputils.ApiInterface;
import assigment.example.com.assignment.apputils.AppUtils;
import assigment.example.com.assignment.login.Login_Activity;
import assigment.example.com.assignment.model.Feed;
import assigment.example.com.assignment.model.Showcases;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetFeed extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    SharedPreferences sharedPreferences;
@BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.swipe_refresh_layout)SwipeRefreshLayout swipeRefreshLayout;
@BindView(R.id.rv_feeds)RecyclerView rv_feeds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_feed);
        ButterKnife.bind(this);
        toolbar.setBackgroundColor(getResources().getColor(R.color.grey));
        sharedPreferences=AppUtils.shared(GetFeed.this);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);

                                        // new stylists().execute();
                                    }
                                }
        );
        getfeeds(sharedPreferences.getString("accesstoken",null),sharedPreferences.getString("email",null));
    }
    private void getfeeds(String accestoken,String email){

        ApiInterface mApiService = AppUtils.getInterfaceService();
        Call<Feed> call = mApiService.getfeeds(accestoken,email);
        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                swipeRefreshLayout.setRefreshing(false);

                Feed feed = response.body();
                Toast.makeText(GetFeed.this,feed.getInfo(), Toast.LENGTH_LONG).show();
           if(feed.getStatus().equalsIgnoreCase("succes"))
           {

               FeedAdapter feedAdapter=new FeedAdapter(GetFeed.this,feed.getShowcases());
               rv_feeds.setHasFixedSize(true);
               RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(GetFeed.this);
               rv_feeds.setLayoutManager(mLayoutManager2);
               rv_feeds.setItemAnimator(new DefaultItemAnimator());

               rv_feeds.setAdapter(feedAdapter);
           }




            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                call.cancel();
                Toast.makeText(GetFeed.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onRefresh() {

        getfeeds(sharedPreferences.getString("accesstoken",null),sharedPreferences.getString("email",null));
    }
}
