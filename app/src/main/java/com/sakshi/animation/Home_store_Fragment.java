package com.sakshi.animation;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Home_store_Fragment extends Fragment {
    private  RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
   private   RecyclerView testing;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_store_, container, false);
        categoryRecyclerView=view.findViewById(R.id.recyclerVierw_category);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(linearLayoutManager);

        final List<CategoryModel> categoryModelList=new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Electronics"));
        categoryModelList.add(new CategoryModel("link","Applications"));
        categoryModelList.add(new CategoryModel("link","Furniture"));
        categoryModelList.add(new CategoryModel("link","Fashion"));
        categoryModelList.add(new CategoryModel("link","Toys"));
        categoryModelList.add(new CategoryModel("link","Sports"));
        categoryModelList.add(new CategoryModel("link","Wall Arts"));
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Shoes"));
        categoryModelList.add(new CategoryModel("link","Books"));

        categoryAdapter=new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


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
         testing=view.findViewById(R.id.home_page_recyclervire);
        LinearLayoutManager testinglayoutManager=new LinearLayoutManager(getContext());
        testinglayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testinglayoutManager);

        List<HomePageModel> homePageModelList=new ArrayList<>();

        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffffff"));
        homePageModelList.add(new HomePageModel(2,"Dial of the day",horizontalProductScrollModelClassList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(3,"title",horizontalProductScrollModelClassList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(2,"Dial of the day",horizontalProductScrollModelClassList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffffff"));
        homePageModelList.add(new HomePageModel(3,"title",horizontalProductScrollModelClassList));
        homePageModelList.add(new HomePageModel(3,"title",horizontalProductScrollModelClassList));


        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        return view;
    }






}
