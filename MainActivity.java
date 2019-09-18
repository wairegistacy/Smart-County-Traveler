package com.project.smartcountytraveller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

    //referencing fields of the main activity
//    Toolbar toolbar;
//    ProgressBar progressBar;
    Button signup;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference the ids of the fields in the main activity
//        toolbar = findViewById(R.id.toolbar);
//        progressBar = findViewById(R.id.progressBar);
        signup = findViewById(R.id.btnSignup);
        login = findViewById(R.id.btnLogin);

        //show title of the app inside the toolbar
//        toolbar.setTitle(R.string.app_name);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

    }
}
