package com.sakshi.animation;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        SystemClock.sleep(3000);
        Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
        finish();
    }

   /* @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser=auth.getCurrentUser();
        if(currentUser == null)
        {

        }
        else {
            Intent homeactivity=new Intent(MainActivity.this,HomeActivity.class);
            startActivity(homeactivity);
            finish();

        }
    }*/
}
