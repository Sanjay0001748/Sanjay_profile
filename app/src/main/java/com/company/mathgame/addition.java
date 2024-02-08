package com.company.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class addition extends AppCompatActivity {


    TextView Score;
    TextView Life;
    TextView timer;
    TextView question;
    EditText answer;
    Button ok;
    Button next;
    Random random=new Random();
    int number1;
    int number2;
    int realanswer;
    int useranswer;
    int userscore=0;
    int userlife=3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        question = findViewById(R.id.textViewquestion);
        answer = findViewById(R.id.editTextanswer);
        Score=findViewById(R.id.textView0);
        Life=findViewById(R.id.textView3);
        timer=findViewById(R.id.textView60);
        ok=findViewById(R.id.buttonok);
        next=findViewById(R.id.buttonnext);
        gamecontinue();


        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                useranswer=Integer.parseInt(answer.getText().toString());
                if(useranswer==realanswer)
                {

                    userscore=userscore+10;
                    question.setText("Congratulation, your answer is correct");
                    Score.setText(" "+ userscore);


                }
                else
                {

                    userlife=userlife-1;
                    question.setText("OOPS, your answer is wrong");
                    Life.setText(" "+ userlife);
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userlife<=0)
                {
                    Toast.makeText(getApplicationContext(),"game over",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(addition.this,result.class);
                    intent.putExtra("score",userscore);
                    startActivity(intent);
                    finish();

                }
                else
                {
                    gamecontinue();
                    answer.setText("");
                }

            }


        });
    }


    public void gamecontinue()
    {
        number1=random.nextInt(100);
        number2=random.nextInt(100);
        realanswer=number1+number2;
        question.setText(number1 +" + "+number2);

    }
}