package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
//import necessary credentials
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
//declaring hand
public class RockPaperScissors extends AppCompatActivity {
    private int beats[] = {2,0,1};
    TextView displayPlayerHand;
    TextView displayComputerHand;
    private String hands[] = {"rock", "paper", "scissors"};
    int i = 0;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);
        Intent intent = getIntent();
        Button buttonRock;
        Button buttonPaper;
        Button buttonSixxor;
        Button buttons[] = new Button[3];
        displayPlayerHand  = findViewById(R.id.pHand); // todo: Textview to show what player picked
        displayComputerHand = findViewById(R.id.cHand);// todo: Textview to show what computer picked
        buttonRock = findViewById(R.id.opOne); // todo: button for rock
        buttonPaper = findViewById(R.id.opTwo); // todo: button for paper
        buttonSixxor = findViewById(R.id.opThree); // todo: button for scissors
//setting on click 
//gets either rock paper or scissor
        buttonRock.setOnClickListener(v->{
            saveFile(evaluateWinner(0, getHand()));
        });
        buttonPaper.setOnClickListener(v->{
            saveFile(evaluateWinner(1, getHand()));
        });
        buttonSixxor.setOnClickListener(v->{
                saveFile(evaluateWinner(2, getHand()));
            });
        }

    public void saveFile(String winner) {
        try {
            FileOutputStream fileOutputStream = openFileOutput(username = (getIntent().getStringExtra("username")) + ".txt",  MODE_APPEND);
            fileOutputStream.write(("\n" +winner+ "\n").getBytes() );
//after output save the file
            Toast.makeText(this, "Saved The file",
                    Toast.LENGTH_LONG).show();
                    //toast error occured
        } catch (IOException e) {
            Toast.makeText(this, "An Error Occurred!!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

//getting randomly rock paper or scissor
    public int getHand() {
        return (int)(Math.random() * 3);
    }
//computer hand is x and player hand is y
    public String evaluateWinner(int x, int y) {
        displayComputerHand.setText(hands[x]);
        displayPlayerHand.setText(hands[y]);

        if (x == y) {
//player and bot same its draw
            Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
            return "Draw";
        }
        if (beats[x] == y) {
            //player beats bot
            Toast.makeText(this, "Player Wins!", Toast.LENGTH_SHORT).show();
            return "Player";

        };
        //player looses 
        Toast.makeText(this, "Player loses!", Toast.LENGTH_SHORT).show();
        return "Computer";
    }

}