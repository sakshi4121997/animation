package com.sakshi.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String title=getIntent().getStringExtra("CategoryName");

        getSupportActionBar().setTitle(title);

        categoryRecyclerView=findViewById(R.id.categoryactivity_recyclerView);


        ////////////// banner ////////////////////////////////////////////


        List<SliderModel> sliderModelList=new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.ic_email_green,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_favorite_black_24dp,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#077AE4"));

        sliderModelList.add(new SliderModel(R.drawable.ic_card_giftcard_black_24dp,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_close,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_favorite_black_24dp,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_home_black_24dp,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_email_blue,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_email_green,"#077AE4"));

        sliderModelList.add(new SliderModel(R.drawable.ic_favorite_black_24dp,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_card_giftcard_black_24dp,"#077AE4"));


        ////////////// banner ////////////////////////////////////////////


        ////////-------> Horizontal_scroll view  <-----------------//////////


        List<HorizontalProductScrollModelClass> horizontalProductScrollModelClassList=new ArrayList<>();

        horizontalProductScrollModelClassList.add(new HorizontalProductScrollModelClass(R.drawable.phone1,"Redmi","Sd 625 processor","Rs.5999/-"));
        horizontalProductScrollModelClassList.add(new HorizontalProductScrollModelClass(R.drawable.ic_card_giftcard_black_24dp,"Redmi","Sd 625 processor","Rs.5999/-"));
        horizontalProductScrollModelClassList.add(new HorizontalProductScrollModelClass(R.drawable.phone1,"Redmi","Sd 625 processor","Rs.5999/-"));
        horizontalProductScrollModelClassList.add(new HorizontalProductScrollModelClass(R.drawable.ic_email_blue,"Redmi","Sd 625 processor","Rs.5999/-"));
        horizontalProductScrollModelClassList.add(new HorizontalProductScrollModelClass(R.drawable.banner,"Redmi","Sd 625 processor","Rs.5999/-"));
        horizontalProductScrollModelClassList.add(new HorizontalProductScrollModelClass(R.drawable.phone1,"Redmi","Sd 625 processor","Rs.5999/-"));
        horizontalProductScrollModelClassList.add(new HorizontalProductScrollModelClass(R.drawable.ic_card_giftcard_black_24dp,"Redmi","Sd 625 processor","Rs.5999/-"));
        horizontalProductScrollModelClassList.add(new HorizontalProductScrollModelClass(R.drawable.phone1,"Redmi","Sd 625 processor","Rs.5999/-"));


        ////////-------> Horizontal_scroll view   <-----------------//////////


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        LinearLayoutManager testinglayoutManager=new LinearLayoutManager(this);
        testinglayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testinglayoutManager);

        List<HomePageModel> homePageModelList=new ArrayList<>();

        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffffff"));
        homePageModelList.add(new HomePageModel(2,"Dial of the day",horizontalProductScrollModelClassList));
        homePageModelList.add(new HomePageModel(3,"title",horizontalProductScrollModelClassList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Dial of the day",horizontalProductScrollModelClassList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffffff"));
        homePageModelList.add(new HomePageModel(3,"title",horizontalProductScrollModelClassList));
        homePageModelList.add(new HomePageModel(3,"title",horizontalProductScrollModelClassList));


        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.main_search_icon) {
            return true;
        }
        else if(id == android.R.id.home);
        {
            finish();
            return true;
        }
       // return super.onOptionsItemSelected(item);



}}

