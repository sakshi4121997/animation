package com.sakshi.animation;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResetPasswordfragment extends Fragment {
    EditText register_email;
    Button reset_pwd_btn;
    TextView go_back;
    FrameLayout frameLayout;
    private ViewGroup emailIconContainer;
    private ImageView emailIcon;
    private TextView emailIconText;
    private ProgressBar progressBar;
    private FirebaseAuth auth;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_reset_passwordfragment, container, false);
       register_email= view.findViewById(R.id.enterEmail);
       reset_pwd_btn=view.findViewById(R.id.sendpassword);
       frameLayout=getActivity().findViewById(R.id.register_frameLayout);
       go_back=view.findViewById(R.id.forgot_go_back);
       progressBar=view.findViewById(R.id.progressBarforgot);
       emailIcon=view.findViewById(R.id.forgotpwdemailIcon);
       emailIconText=view.findViewById(R.id.forgot_pwd_email_icon_text);
       emailIconContainer=view.findViewById(R.id.linearlayoutforgotcontainer);
       auth=FirebaseAuth.getInstance();
       return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        register_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                checkInputs();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTosignIn(new SignInFragment());
            }
        });
        reset_pwd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TransitionManager.beginDelayedTransition(emailIconContainer);
                emailIconText.setVisibility(View.GONE);
                    //transitionmanger.begimtransition mai jb viewgroup pass krte hai to vo trasition ki help se appni place chnge krnge

                    TransitionManager.beginDelayedTransition(emailIconContainer);
                    emailIcon.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.VISIBLE);



                reset_pwd_btn.setEnabled(false);
                reset_pwd_btn.setTextColor(Color.argb(50,255,255,255));

                auth.sendPasswordResetEmail(register_email.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    progressBar.setVisibility(View.INVISIBLE);
                                    ScaleAnimation scaleAnimation=new ScaleAnimation(1,0,1,0,
                                            emailIcon.getWidth()/2, emailIcon.getHeight()/2);
                                    scaleAnimation.setDuration(100);
                                    scaleAnimation.setInterpolator(new AccelerateInterpolator());
                                    scaleAnimation.setRepeatMode(Animation.REVERSE);
                                    scaleAnimation.setRepeatCount(1);
                                    scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                                        @Override
                                        public void onAnimationStart(Animation animation) {

                                        }


                                        @Override
                                        public void onAnimationEnd(Animation animation) {
                                            emailIconText.setText("Recovery email sent successfullu on your email ! Check your inbox");
                                            emailIconText.setTextColor(getResources().getColor(R.color.SucessGreen));
                                            TransitionManager.beginDelayedTransition(emailIconContainer);
                                            emailIconText.setVisibility(View.VISIBLE);

                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {
                                            emailIcon.setImageResource(R.drawable.ic_email_green);
                                        }
                                    });
                                    emailIcon.startAnimation(scaleAnimation);

                                }
                                else {

                                    String error=task.getException().getMessage();
                                    emailIconText.setVisibility(View.GONE);

                                    emailIconText.setText(error);
                                    emailIconText.setTextColor(getResources().getColor(R.color.Red));
                                    TransitionManager.beginDelayedTransition(emailIconContainer);
                                    emailIconText.setVisibility(View.VISIBLE);
                                    progressBar.setVisibility(View.GONE);

                                }
                                reset_pwd_btn.setEnabled(true);
                                reset_pwd_btn.setTextColor(Color.rgb(255,255,255));

                            }
                        });


            }
        });
    }


    private void checkInputs() {
        if(TextUtils.isEmpty(register_email.getText()))
        {
            reset_pwd_btn.setEnabled(false);
            reset_pwd_btn.setTextColor(Color.argb(50,255,255,255));
        }
        else {
            reset_pwd_btn.setEnabled(true);
            reset_pwd_btn.setTextColor(Color.rgb(255,255,255));

        }
    }
    private void sendTosignIn(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_from_right);
        fragmentTransaction.replace(frameLayout.getId(), fragment).addToBackStack(null).commit();



    }
}
