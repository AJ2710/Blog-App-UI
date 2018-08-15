package com.example.ajitg.myblog;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class TrendingBlogRecyclerAdapter extends RecyclerView.Adapter<TrendingBlogRecyclerAdapter.TrendingBlogViewHolder> {

    public static List<TrendingBlogs> recentBlogs;
    public Context mContext;

    public TrendingBlogRecyclerAdapter(Context mContext,List<TrendingBlogs> recentBlogs) {

        this.mContext = mContext;
        this.recentBlogs = recentBlogs;

    }

    @NonNull
    @Override
    public TrendingBlogViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tranding_blogs_layout , viewGroup , false);
        return (new TrendingBlogViewHolder(view));

    }

    @Override
    public void onBindViewHolder(@NonNull TrendingBlogViewHolder trendingBlogViewHolder,final int i) {

        trendingBlogViewHolder.trending_RecyclerView_TextHeader.setText(recentBlogs.get(i).getHeader());
        trendingBlogViewHolder.trending_RecyclerView_TextSubHeader.setText(recentBlogs.get(i).getSubHeader());
        Glide.with(mContext).load(recentBlogs.get(i).getImages()).into(trendingBlogViewHolder.trendingImageView);
        // trendingBlogViewHolder.trendingImageView.setImageResource(recentBlogs.get(i).getImages());



        trendingBlogViewHolder.exploreFlatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext , BlogActivity.class);
                intent.putExtra("image_number" , i);
                mContext.startActivity(intent);

            }
        });

        trendingBlogViewHolder.shareFlatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mContext , "Share clicked" , Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return recentBlogs.size();
    }

    public static class TrendingBlogViewHolder extends RecyclerView.ViewHolder{

        TextView trending_RecyclerView_TextHeader;
        TextView trending_RecyclerView_TextSubHeader;
        ImageView trendingImageView;
        LinearLayout trendingBlogsLinearLayout;
        AppCompatButton exploreFlatbutton , shareFlatButton;

        public TrendingBlogViewHolder(@NonNull View itemView) {
            super(itemView);

            trending_RecyclerView_TextHeader = itemView.findViewById(R.id.trending_RecyclerView_TextHeader);
            trending_RecyclerView_TextSubHeader = itemView.findViewById(R.id.trending_RecyclerView_TextSubHeader);
            trendingImageView = itemView.findViewById(R.id.trendingImageView);
            trendingBlogsLinearLayout = itemView.findViewById(R.id.trendingBlogsLinearLayout);
            shareFlatButton = itemView.findViewById(R.id.shareFlatButton);
            exploreFlatbutton = itemView.findViewById(R.id.exploreFlatbutton);
        }


    }

}
