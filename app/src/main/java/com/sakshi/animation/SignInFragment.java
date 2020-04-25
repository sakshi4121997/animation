package com.sakshi.animation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.sakshi.animation.RegisterActivity.onResetPasswordFragment;


public class SignInFragment extends Fragment {
    TextView dontHaveAccount,forgotbtn;
    FrameLayout frameLayout;
    EditText email,password;
    Button signin;
    ImageView closeBtn;
    ProgressBar progressBar;
    private String emailPatten ="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    private FirebaseAuth mAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        dontHaveAccount = view.findViewById(R.id.dontHaveAccount);
        email = view.findViewById(R.id.email_signin);
        password = view.findViewById(R.id.password_signin);
        signin = view.findViewById(R.id.login);
        closeBtn=view.findViewById(R.id.close_signin);
        forgotbtn=view.findViewById(R.id.forgotPassword);
        progressBar=view.findViewById(R.id.progressBar_signim);
        frameLayout = getActivity().findViewById(R.id.register_frameLayout);

        mAuth = FirebaseAuth.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    dontHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         sendToSignUpFragment(new SignupFragment());

            }


        });

    forgotbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onResetPasswordFragment=true;
            sendToSignUpFragment(new ResetPasswordfragment());
        }
    });
    email.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkInputs();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });
    password.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }


        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
          checkInputs();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });
    closeBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToHomeScreen();
        }
    });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailPwd();
            }
        });


    }

    private void goToHomeScreen() {
        startActivity(new Intent(getActivity(),HomeActivity.class));
        getActivity().finish();
    }



    private void checkEmailPwd() {
        if(email.getText().toString().matches(emailPatten)){
            if(password.getText().toString().length()>=8) {
                progressBar.setVisibility(View.VISIBLE);
                signin.setEnabled(false);

                mAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    progressBar.setVisibility(View.INVISIBLE);

                                   goToHomeScreen();

                                }else {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    signin.setEnabled(true);
                                    signin.setTextColor(Color.rgb(255,255,255));
                                    Toast.makeText(getContext(), task.getException().toString(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }); {


                }

            }else {
                Toast.makeText(getContext(), "Incorrect password", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getContext(), "Incorrect email", Toast.LENGTH_SHORT).show();
        }

    }


    private void checkInputs() {
        if(!TextUtils.isEmpty(email.getText().toString()))
        { if(!TextUtils.isEmpty(password.getText().toString()))
        {
            signin.setEnabled(true);
            signin.setTextColor(Color.rgb(255,255,255));
        }else{
            signin.setEnabled(false);
            signin.setTextColor(Color.argb(50,255,255,255));
        }


        }else {
            signin.setEnabled(false);
            signin.setTextColor(Color.argb(50,255,255,255));
        }
    }

    private void sendToSignUpFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right,R.anim.slide_out_from_left);
        fragmentTransaction.replace(frameLayout.getId(),fragment).addToBackStack(null).commit();


    }
}
