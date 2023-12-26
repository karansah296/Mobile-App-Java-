package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
//import necessary packages
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActivityPage extends AppCompatActivity {

    @Override
    //oncreate function
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        Intent intent = getIntent();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Calendar getCalender = Calendar.getInstance();
        String currentDate = format.format(getCalender.getTime());
        TextView usernameDisplay = findViewById(R.id.usernameDisplay); // TODO: textview
        TextView passwordDisplay = findViewById(R.id.passwordDisplay);// TODO: textview
        TextView dateDisplay = findViewById(R.id.dateDisplay);//TODO: textview
        usernameDisplay.setText(intent.getStringExtra("username"));
        passwordDisplay.setText(intent.getStringExtra("password"));
        dateDisplay.setText(currentDate);

           //find by id
           //used button on click function
        ((Button) findViewById(R.id.mafs)).setOnClickListener(v->{ // TODO: button to go to mathematics
            startActivity(new Intent(this, Mathematics.class));
        });

        ((Button) findViewById(R.id.game)).setOnClickListener(v->{ // TODO: button to go to RockPaperScissors
            Intent intents = new Intent(this, RockPaperScissors.class);
            intents.putExtra("username",intent.getStringExtra("username"));
            startActivity(intents);
        });

    }


}