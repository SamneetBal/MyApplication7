package com.example.admin.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    String emails, passs, names, locations, genders, cpasss;
    EditText email, pass, name, location, gender, cpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void Signup(View view) {


        if (Patterns.EMAIL_ADDRESS.matcher(emails).matches()) {

        } else {
            Toast.makeText(signup.this, "invalid email", Toast.LENGTH_SHORT).show();
            return;
        }


        if (passs.length() >= 8 && passs.length() < 33) {

        } else {
            Toast.makeText(signup.this, "password must be between 8-33 character", Toast.LENGTH_SHORT).show();
            return;
        }

        if (genders.length() >= 2) {

        } else {
            Toast.makeText(signup.this, "Enter address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (cpasss.equals(passs)) {

        } else {
            Toast.makeText(signup.this, "confirm password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (genders.length() >= 3) {

        } else {
            Toast.makeText(signup.this, "select gender", Toast.LENGTH_SHORT).show();
            return;
        }

        final ProgressDialog progress_bar = new ProgressDialog(signup.this);
        progress_bar.setTitle("please wait");
        progress_bar.setMessage("Create account");
        progress_bar.show();

        final FirebaseAuth f_auth = FirebaseAuth.getInstance();

        OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progress_bar.hide();

                createaccount data = new createaccount(names, locations, genders);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                if (task.isSuccessful()) {
                    String email = f_auth.getCurrentUser().getEmail().replace(".", "");
                    database.getReference().child(email).setValue(data);
                    Toast.makeText(signup.this, "done", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(signup.this, Home.class);
                    startActivity(i);
                } else {
                    Toast.makeText(signup.this, "error try again", Toast.LENGTH_SHORT).show();
                }
            }
        };

        f_auth.createUserWithEmailAndPassword(emails, passs).addOnCompleteListener(listener);


    }
}
