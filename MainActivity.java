package com.project.smartcountytraveller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    //referencing fields of the main activity
    Toolbar toolbar;
    ProgressBar progressBar;
    EditText username;
    EditText email;
    EditText password;
    Button signup;
    Button login;

    //declare instance of FirebaseAuth
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference the ids of the fields in the main activity
        toolbar = findViewById(R.id.toolbar);
        progressBar = findViewById(R.id.progressBar);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.btnSignup);
        login = findViewById(R.id.btnLogin);

        //show title of the app inside the toolbar
        toolbar.setTitle(R.string.app_name);

        //add this to establish a connection with FireBase
        firebaseAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show progressBar
                progressBar.setVisibility(View.VISIBLE);
                //call FireBase to save user's data
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    //determines whether a user has registered successfully or not
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       progressBar.setVisibility(View.GONE);
                       //if user has registered successfully, one will get a toast message showing registered successfully
                      if(task.isSuccessful()){
                          Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                          //once user has successfully registered their details
                          username.setText("");
                          email.setText("");
                          password.setText("");
                      }
                      //if user's data was not saved successfully in FireBase, a message will be displayed from FireBase to show it was not successful
                      else{
                              Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
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
