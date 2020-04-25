package com.sakshi.animation.products;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sakshi.animation.Home_store_Fragment;
import com.sakshi.animation.R;
import com.sakshi.animation.SignInFragment;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {
    private ViewPager productImagesVierPager;
    private TabLayout viewPagerIndictor;

    private ViewPager productDetail_viewPager;
    private TabLayout productDetail_tablayout;
    ///////RatingLayout////
    private LinearLayout rateNowlayoutContainer;
    private Button buy_now_btn;
    ///////RatingLayout////

    private static boolean ALREADY_ADDED_TO_WISH_LIST = false;
    private FloatingActionButton addToWishList;
    public static boolean onResetPasswordFragment=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
    buy_now_btn=findViewById(R.id.buy_now_btn);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        productImagesVierPager = findViewById(R.id.product_image_viewPager);
        viewPagerIndictor = findViewById(R.id.product_view_pager_indicator);
        addToWishList = findViewById(R.id.add_to_wishlist_btn);

        productDetail_viewPager = findViewById(R.id.product_details_viewPager);
        productDetail_tablayout = findViewById(R.id.product_details_tablayout);

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.phone1);
        productImages.add(R.drawable.phone1);
        productImages.add(R.drawable.phone1);
        productImages.add(R.drawable.phone1);


        ProductImageViewPagerAdapter productImageAdapter = new ProductImageViewPagerAdapter(productImages);
        productImagesVierPager.setAdapter(productImageAdapter);

        viewPagerIndictor.setupWithViewPager(productImagesVierPager, true);
        addToWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ALREADY_ADDED_TO_WISH_LIST == true) {
                    ALREADY_ADDED_TO_WISH_LIST = false;
                    addToWishList.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));

                } else {
                    ALREADY_ADDED_TO_WISH_LIST = true;
                    addToWishList.setSupportImageTintList(getResources().getColorStateList(R.color.colorPrimary));

                }
            }
        });

        productDetail_viewPager.setAdapter(new ProductDetailsVPAdapter(getSupportFragmentManager(), productDetail_tablayout.getTabCount()));
        productDetail_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetail_tablayout));
        productDetail_tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetail_viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        ///////rating layout////
        rateNowlayoutContainer=findViewById(R.id.rate_now_container);
        //this will set the click listener in all star
        for(int x = 0;x < rateNowlayoutContainer.getChildCount();x++){
            //hr ek star ke liye position set ki h
            final int star_position= x;
            rateNowlayoutContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(star_position);
                }
            });

        }
        // /////rating layout////
        buy_now_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent=new Intent(ProductDetailsActivity.this,DeliverActivity.class);
             startActivity(deliveryIntent);
            }
        });
    }


    private void setRating(int star_position) {
        //har ek star ka color chnge krega
        for(int x=0;x < rateNowlayoutContainer.getChildCount();x++){
            ImageView starbtn= (ImageView) rateNowlayoutContainer.getChildAt(x);
            starbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if(x <= star_position){
                starbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFBB00")));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_card_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.product_search_icon) {
            return true;
        }
        if (id == R.id.product_my_cart) {
            return true;
        } else if (id == android.R.id.home) ;
        {
            finish();
            return true;
        }
    }

/*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(onResetPasswordFragment){
                onResetPasswordFragment=false;
                sendTosignIn(new Home_store_Fragment());
                return false;

            }
        }
        return super.onKeyDown(keyCode, event);
    }
     private void sendTosignIn(Fragment fragment) {
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_from_right);
        fragmentTransaction.replace(frameLayout.getId(), fragment).addToBackStack(null).commit();



    }
*/

}
