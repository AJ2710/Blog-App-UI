package com.example.ajitg.myblog;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.example.ajitg.myblog.TrendingBlogRecyclerAdapter.recentBlogs;

public class BlogActivity extends AppCompatActivity {

    boolean flag = true;

    View blogActivity;
    LinearLayout backButtonLinearLayout;
    ImageView blogPageImageView , backIconImageView , likedImageView;
    TextView blogPageTextView , backButtonTextView , saveButtonImageView , blogPageHeadingTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        Intent intent = getIntent();
        int imageNumber = intent.getIntExtra("image_number" ,0);

        blogActivity = findViewById(R.id.blogActivity);

        backButtonLinearLayout = findViewById(R.id.backButtonLinearLayout);
        backButtonLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });

        blogPageImageView = findViewById(R.id.blogPageImageView);
        Glide.with(this).load(recentBlogs.get(imageNumber).getImages()).into(blogPageImageView);

        backIconImageView = findViewById(R.id.backIconImageView);
        likedImageView = findViewById(R.id.likedImageView);

        saveButtonImageView = findViewById(R.id.saveButtonImageView);
        saveButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(blogActivity , "Saved" , Snackbar.LENGTH_SHORT).show();

            }
        });

        blogPageHeadingTextView = findViewById(R.id.blogPageHeadingTextView);
        blogPageHeadingTextView.setText(recentBlogs.get(imageNumber).getHeader());

        blogPageTextView = findViewById(R.id.blogPageTextView);
        blogPageTextView.setKeyListener(null);
        blogPageTextView.setEnabled(false);

        blogPageTextView.setText(R.string.blogPageTextContent);

        likedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag){

                    likedImageView.setImageResource(R.drawable.heart_filled_icon);
                    flag = false;


                }else{

                    likedImageView.setImageResource(R.drawable.heart_outline_icon);
                    flag = true;

                }

            }
        });

    }
}
