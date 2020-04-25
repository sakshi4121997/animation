package com.sakshi.animation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    public static boolean onResetPasswordFragment=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        frameLayout=findViewById(R.id.register_frameLayout);

        setFragment(new SignInFragment());

    }
    // for custom back press for going to signin not out of the project


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(onResetPasswordFragment){
                onResetPasswordFragment=false;
                sendTosignIn(new SignInFragment());
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


    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.register_frameLayout,fragment).commit();
    }

}
