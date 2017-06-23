package assigment.example.com.assignment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import assigment.example.com.assignment.R;
import assigment.example.com.assignment.model.Feed;
import assigment.example.com.assignment.model.Showcases;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Start4me on 6/24/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {
    Context mContext;
    ArrayList<Showcases> al_list;
    HashMap<String, String> hashMap;
    public static ArrayList<HashMap<String,String>> al_listtime;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_id)TextView tv_id;
        @BindView(R.id.tv_title)TextView tv_title;
        @BindView(R.id.tv_description)TextView tv_description;
        @BindView(R.id.tv_year)TextView tv_year;
        @BindView(R.id.tv_userid)TextView tv_userid;

        int position;


        public MyViewHolder(View rowView) {
            super(rowView);
            ButterKnife.bind(this,rowView);
        }
    }
    public FeedAdapter(Context context, ArrayList<Showcases> moviesList) {

        this.mContext=context;
        this.al_list = moviesList;

    }
    @Override
    public FeedAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customfeed, parent, false);

        return new FeedAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FeedAdapter.MyViewHolder holder, final int position) {
        //  Toast.makeText(mContext,""+position,Toast.LENGTH_SHORT).show();
        // hashMap = al_list.get(position);


        holder.tv_id.setText("ID \n"+al_list.get(position).getId());
        holder.tv_title.setText("Title \n"+al_list.get(position).getTitle());
        holder.tv_description.setText("Description \n"+al_list.get(position).getDescription());
        holder.tv_year.setText("Year \n"+al_list.get(position).getYear());
        holder.tv_userid.setText("User_Id \n"+al_list.get(position).getUser_id());


    }

    @Override
    public int getItemCount() {

        return al_list.size();//al_list.size();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
}

