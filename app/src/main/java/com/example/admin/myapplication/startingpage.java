package com.example.admin.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class startingpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startingpage);
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

                if(firebaseAuth.getCurrentUser()!=null){
                    //home page
                    finish();
                    startActivity(new Intent(getApplicationContext(),Home.class));
                }
                else {
                    Intent i = new Intent(startingpage.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, 3000);

    }
}
