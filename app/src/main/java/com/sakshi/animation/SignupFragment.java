package com.sakshi.animation;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class SignupFragment extends Fragment {
    TextView alreadyHaveACcount;
    FrameLayout frameLayout;
    EditText email,name,password,confirmPassword;
    Button signup;
    ProgressBar progressBar;
    ImageView closeBtn;
    private FirebaseAuth mAuth;
    private String emailPatten ="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    private FirebaseFirestore firebaseFireStore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment_signup, container, false);
        alreadyHaveACcount=view.findViewById(R.id.alreadyHaveAccount);
        email=view.findViewById(R.id.email_signup);
        password=view.findViewById(R.id.password_signup);
        name=view.findViewById(R.id.name_signup);
        progressBar=view.findViewById(R.id.progressBarSignup);
        confirmPassword=view.findViewById(R.id.confmpwd_signup);
        closeBtn=view.findViewById(R.id.close_signup);
        frameLayout=getActivity().findViewById(R.id.register_frameLayout);
        signup=view.findViewById(R.id.signUpbtn);

        mAuth = FirebaseAuth.getInstance();
        firebaseFireStore=FirebaseFirestore.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              checkInputs();
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              checkInputs();
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              checkInputs();
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              checkInputs();
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });



        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkEmailPassword();


            }
        });
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHomeScreen();
            }
        });

        alreadyHaveACcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTosignIn(new SignInFragment());
            }
        });

    }

    private void goToHomeScreen() {
        Intent intent=new Intent(getActivity(),HomeActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    private void checkInputs() {
        if(!TextUtils.isEmpty(email.getText()))
        { if(!TextUtils.isEmpty(name.getText()))
               { if(!TextUtils.isEmpty(password.getText()) && password.length() >=8)
                   { if(!TextUtils.isEmpty(confirmPassword.getText()))
                       { signup.setEnabled(true);
                 signup.setTextColor(Color.rgb(255,255,255));
                       }
                       else {
                           signup.setEnabled(false);
                   signup.setTextColor(Color.argb(50,255,255,255));
                       }
                   }
                   else{
                   signup.setEnabled(false);
                   }}
            else {
            signup.setEnabled(false);
            signup.setTextColor(Color.argb(50,255,255,255));
            }

        }
            else
        {
            signup.setEnabled(false);
            signup.setTextColor(Color.argb(50,255,255,255));
        }
    }

     private void checkEmailPassword() {
//         Drawable customIconError= getResources().getDrawable(R.drawable.ic_error_outline_black_24dp);
//         customIconError.setBounds(0,0,customIconError.getIntrinsicWidth(),customIconError.getIntrinsicHeight());

        if(email.getText().toString().matches(emailPatten)){
            if ((password.getText().toString().equals(confirmPassword.getText().toString()))){
                    progressBar.setVisibility(View.VISIBLE);


                    mAuth.createUserWithEmailAndPassword(email.getText().toString() , password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                   if(task.isSuccessful())
                                   {
                                       Map<String,String> userdata=new HashMap<>();
                                       userdata.put("fullname",name.getText().toString());
                                       firebaseFireStore.collection("USERS").add(userdata)
                                               .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                                   @Override
                                                   public void onComplete(@NonNull Task<DocumentReference> task) {
                                                       if(task.isSuccessful())
                                                       {
                                                           progressBar.setVisibility(View.INVISIBLE);
                                                          goToHomeScreen();
                                                       }
                                                       else {
                                                            signup.setEnabled(true);

                                                               signup.setTextColor(Color.rgb(255,255,255));
                                                           Toast.makeText(getActivity(), task.getException().toString(), Toast.LENGTH_SHORT).show();

                                                       }
                                                   }
                                               });
                                   }
                                   else {signup.setEnabled(true);

                                       signup.setTextColor(Color.rgb(255,255,255));
                                       Toast.makeText(getActivity(), task.getException().toString(), Toast.LENGTH_SHORT).show();
                                   }
                                }
                            });
            }
            else {
                confirmPassword.setError("password doesn't match!");
            }
         }else{
      email.setError("Enter the valid email");        }


     }
        private void sendTosignIn(Fragment fragment) {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_from_right);
            fragmentTransaction.replace(frameLayout.getId(), fragment).addToBackStack(null).commit();



        }

}
