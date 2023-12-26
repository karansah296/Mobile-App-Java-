package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
//import necessary credentials
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
//main function
public class MainActivity extends AppCompatActivity {
    private HashMap<String, String> users = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//find view by id
        EditText inputUsername = findViewById(R.id.unamei);
        EditText inputPassword = findViewById(R.id.upassi);
        Button submitButton = findViewById(R.id.sbtn);
        users.put("admin", "adminpassword");
        users.put("user1","user1passsword");
        users.put("user2","user2password");
        //setting button on click
        //checking username password to login
        submitButton.setOnClickListener(v->{
            String username = inputUsername.getText().toString().trim();
            String password = inputPassword.getText().toString().trim();
            if(users.containsKey(username) && users.get(username).equals(password)) {
                login(username, password);
            }

        });
    }

    public void login(String username, String password) {
        Intent intent = new Intent(this, ActivityPage.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        startActivity(intent);
    }

}