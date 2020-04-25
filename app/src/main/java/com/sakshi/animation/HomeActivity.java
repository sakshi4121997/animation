package com.sakshi.animation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sakshi.animation.Account.MyAccountFragment;
import com.sakshi.animation.Wishlist.MyWishListFragment;
import com.sakshi.animation.myOrder.MyOrderFragment;
import com.sakshi.animation.products.MyCartFragment;
import com.sakshi.animation.rewards.MyRewardsFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int HOME_FRAGMENT=0;
    private static final int CART_FRAGMENT=1;
    private static final  int ORDER_FRAGMENT=2;
    private static final  int WISHLIST_FRAGMENT=3;
    private static final  int REWARD_FRAGMENT=4;
    private static final  int ACCOUNT_FRAGMENT=5;


    private   FrameLayout  framelayout;
    private static int currentFragment=-1;
    private NavigationView navigationView;
    private TextView tootTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       //
      /*  framelayout=findViewById(R.id.main_frame_layout);
        setFragment(new Home_store_Fragment(),HOME_FRAGMENT);*/

          tootTitle=findViewById(R.id.text_logo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        framelayout=findViewById(R.id.main_frame_layout);
        setFragment(new Home_store_Fragment(),HOME_FRAGMENT);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(currentFragment == HOME_FRAGMENT){
            super.onBackPressed();}
            else {

                tootTitle.setVisibility(View.VISIBLE);
                invalidateOptionsMenu();
                setFragment(new Home_store_Fragment(),HOME_FRAGMENT);
                navigationView.getMenu().getItem(0).setChecked(true);

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        if(currentFragment == HOME_FRAGMENT) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getMenuInflater().inflate(R.menu.home, menu);
        }
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
            // todo:search
            return true;
        } else if (id == R.id.main_notification_icon) {

            return true;
        } else if (id == R.id.main_cart_icon) {

            gotoFragment("My Cart",new MyCartFragment(),CART_FRAGMENT);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void gotoFragment(String title,Fragment fragment,int fragmentNo) {
        //actionBar P icon invisible kr deta sre
        tootTitle.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
getSupportActionBar().setTitle(title);
        invalidateOptionsMenu();
        setFragment(fragment,fragmentNo);
        if(fragmentNo == CART_FRAGMENT) {
            navigationView.getMenu().getItem(3).setChecked(true);
        }
        else if(fragmentNo == ORDER_FRAGMENT)
        {
            navigationView.getMenu().getItem(1).setChecked(true);
        } else if(fragmentNo == WISHLIST_FRAGMENT)
        {
            navigationView.getMenu().getItem(4).setChecked(true);
        }else if(fragmentNo == REWARD_FRAGMENT)
        {
            navigationView.getMenu().getItem(5).setChecked(true);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_my_store) {

            tootTitle.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
            setFragment(new Home_store_Fragment(),HOME_FRAGMENT);

        } else if (id == R.id.nav_my_order) {
         
            gotoFragment("My Order",new MyOrderFragment(),ORDER_FRAGMENT);


        } else if (id == R.id.nav_my_rewards) {
            gotoFragment("My Rewards",new MyRewardsFragment(),REWARD_FRAGMENT);


        } else if (id == R.id.nav_my_cart) {
            gotoFragment("My Cart",new MyCartFragment(),CART_FRAGMENT);


        } else if (id == R.id.nav_my_wishlist) {
            gotoFragment("My WishList", new MyWishListFragment(),WISHLIST_FRAGMENT);

        } else if (id == R.id.nav_my_account) {
            gotoFragment("My Account",new MyAccountFragment(),ACCOUNT_FRAGMENT);

        }else if (id == R.id.nav_sign_out) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setFragment(Fragment fragment,int fragmentNo) {
        if(fragmentNo != currentFragment) {
            currentFragment = fragmentNo;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(framelayout.getId(), fragment).commit();



        }
    }
}
