package com.example.ajitg.myblog;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class BlogListActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView toolbar_Title;
    RecyclerView blog_List_Recycler_View;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    LinearLayout myBlog_TextView , likedBlog_TextView , settings_TextView , help_TextView ;
    TextView personalTextView , professionalTextView , businessTextView , sportsTextView , photographyTextView , travelTextView , foodTextView , lifeStyleTextView , humorTextView , beautyTextView;
    List<TrendingBlogs> recentBlogs;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.blog_list_menus , menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);

        }else{

            super.onBackPressed();

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch(id){

            case R.id.searchIcon:
                Toast.makeText(BlogListActivity.this , "Searching for blogs" , Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuSetting:
                Toast.makeText(BlogListActivity.this , "Settings for customizations" , Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addItemInRecyclerView(){

        recentBlogs = new ArrayList<>();
        recentBlogs.add(new TrendingBlogs(R.drawable.laugh ,"Laughing is best choice ..." , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do ..."));
        recentBlogs.add(new TrendingBlogs(R.drawable.drone ,"Drones in fashion nowadays ..." , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do  ..."));
        recentBlogs.add(new TrendingBlogs(R.drawable.bot ,"Artificial intelligence at its best ..." , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do ..."));
        recentBlogs.add(new TrendingBlogs(R.drawable.nasa ,"Nasa, New Achievement for ..." , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do ..."));
        recentBlogs.add(new TrendingBlogs(R.drawable.tech ,"Google's project for virtual ..." , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do ..."));
        recentBlogs.add(new TrendingBlogs(R.drawable.programming ,"Huge demand for Data scientist ..." , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do ..."));
        recentBlogs.add(new TrendingBlogs(R.drawable.refresh ,"Length of best vacation perioid ..." , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do ..."));
        recentBlogs.add(new TrendingBlogs(R.drawable.beauty ,"Benefits of oranges for ..." , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do ..."));


        blog_List_Recycler_View.setLayoutManager(new LinearLayoutManager(this ));
        blog_List_Recycler_View.setHasFixedSize(true);

        TrendingBlogRecyclerAdapter adapter = new TrendingBlogRecyclerAdapter(this , recentBlogs);
        blog_List_Recycler_View.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        //Toolbar
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this , drawerLayout ,toolbar , R.string.open_drawer , R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();



        navigationView = findViewById(R.id.navigationView);


        View inflated = getLayoutInflater().inflate(R.layout.navigation_header ,navigationView);
        myBlog_TextView = inflated.findViewById(R.id.myBlog_TextView);
        myBlog_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Blogs written by me" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        likedBlog_TextView = inflated.findViewById(R.id.likedBlog_TextView);
        likedBlog_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Blogs liked by me" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        personalTextView = inflated.findViewById(R.id.personalTextView);
        personalTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Personal" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        professionalTextView = inflated.findViewById(R.id.professionalTextView);
        professionalTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Professional" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        businessTextView = inflated.findViewById(R.id.businessTextView);
        businessTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Business" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        sportsTextView = inflated.findViewById(R.id.sportsTextView);
        sportsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Sports" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        photographyTextView = inflated.findViewById(R.id.photographyTextView);
        photographyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Photography" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        travelTextView = inflated.findViewById(R.id.travelTextView);
        travelTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Travel" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        foodTextView = inflated.findViewById(R.id.foodTextView);
        foodTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Food" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        lifeStyleTextView = inflated.findViewById(R.id.lifeStyleTextView);
        lifeStyleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Life style" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        humorTextView = inflated.findViewById(R.id.humorTextView);
        humorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "humor" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        beautyTextView = inflated.findViewById(R.id.beautyTextView);
        beautyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Beauty" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        settings_TextView = inflated.findViewById(R.id.settings_TextView);
        settings_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Setting" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        help_TextView = inflated.findViewById(R.id.help_TextView);
        help_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BlogListActivity.this , "Help & feedback" , Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });








        //Toolbar Title TextView
        toolbar_Title = findViewById(R.id.toolbar_Title);


        //RecyclerView
        blog_List_Recycler_View = findViewById(R.id.blog_List_Recycler_View);

        addItemInRecyclerView();

    }
}
