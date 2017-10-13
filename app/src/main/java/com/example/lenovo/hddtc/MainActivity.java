package com.example.lenovo.hddtc;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextView mytext1;
    private Button btn1;
    private static  final  int RC_SIGN_IN=1;
    private Button btn2;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mauthstatelistener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        mytext1=(TextView)findViewById(R.id.mytext1);
firebaseAuth=FirebaseAuth.getInstance();





        mauthstatelistener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(MainActivity.this, "Welcome You are logged in", Toast.LENGTH_SHORT).show();

                } else {

                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder().setIsSmartLockEnabled(false)
                                    .setProviders(
                                            AuthUI.EMAIL_PROVIDER,

                                            AuthUI.GOOGLE_PROVIDER

                                    )
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }
    public static void getid(View view){
        switch(view.getId()){
            case  R.id.btn1:

            case R.id.btn2:

        }
    }
}

