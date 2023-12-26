package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class Mathematics extends AppCompatActivity {
    TextView questionDisplay;
    EditText inputAnswer;
    TextView scoreDisplay;
    Button answerSubmitButton;
    //setting questions
    String[] questions = {"1+1", "3 - (5 – 6 ÷ 3)", "– 25 + 14 ÷ (5 - 3)", "22 - (1/4) {-5 - (- 48) ÷ (-16)}", "55/11"};
    String[] answers = {"2", "0", "-18", "24", "5"};
    int score = 0;
    int curr = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematics);

        questionDisplay = findViewById(R.id.qn);// TODO: textview to display questions
        scoreDisplay = findViewById(R.id.score);// TODO: textview to display scores
        inputAnswer =   findViewById(R.id.ans);// TODO: EditText to input answer
        answerSubmitButton =  findViewById(R.id.okBtn);// TODO: Button to submit answer
        answerSubmitButton.setText("Start");
        answerSubmitButton.setOnClickListener(v->{
            quiz();
        });

    }

    public void quiz(){
        if(curr >= questions.length) {
            endQuiz();
            return;
        }
        //setting on click to submit answer
        questionDisplay.setText(questions[curr]);
        answerSubmitButton.setText("Submit answer");
        answerSubmitButton.setOnClickListener(v-> {
            checkAnswer();
            curr++;
            quiz();
        });

    }
//checking the answers
    public void checkAnswer() {
        if (!answers[curr].equals(inputAnswer.getText().toString()))
        {
            //if incorrect toast message incorrect
            Toast.makeText(this, "Incorrect!!!" + answers[curr] + " " + inputAnswer.getText().toString(),
                    Toast.LENGTH_LONG).show();
            return;
        }
        ++score;
        //if correct toast message correct
        scoreDisplay.setText(score+"");
        Toast.makeText(this, "Correct!!!",
                Toast.LENGTH_LONG).show();
    }

    public void endQuiz() {
        //getting how much you scored
        questionDisplay.setText("You scored " + score + " Input your name to store your score");
//setting on click to save score
        answerSubmitButton.setOnClickListener(v-> {
            try {
                String userSaveableText = inputAnswer.getText().toString() + " Scored: " + score + " On" + new Date();

                FileOutputStream fileOutputStream = openFileOutput("Mathematics.txt",  MODE_PRIVATE);
                fileOutputStream.write(userSaveableText.getBytes());
//toast message saved the file
                Toast.makeText(this, "Saved The file",
                        Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                //if error toast message error occured
                Toast.makeText(this, "An Error Occurred!!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            } finally {
                startActivity(new Intent(this, Mathematics.class));
                finish();
            }
        });


        return;
    }




}