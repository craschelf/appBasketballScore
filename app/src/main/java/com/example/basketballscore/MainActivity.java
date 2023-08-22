package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String SCORE_1 = "score1";
    public static final String SCORE_2 = "score2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView score1 = binding.score1;
        TextView score2 = binding.textView5;
        ImageButton restaurar = binding.imageButton3;




        binding.imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String score1 = binding.score1.getText().toString();
                String score2 = binding.textView5.getText().toString();
                openScoreActivity(score1, score2);
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumar1(score1);
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restar1(score1);
                siMenor0(score1);
            }
        });


        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumar2(score1);
            }
        });
        

        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sumar1(score2);
            }
        });

        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sumar2(score2);
            }
        });

        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restar1(score2);
                siMenor0(score2);
            }
        });

        binding.imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score1.setText("0");
                score2.setText("0");

            }
        });

    }

    public void siMenor0(TextView textView){
        String scoreStr= textView.getText().toString();

        if(Integer.parseInt(scoreStr) < 0) {
            Log.d("Main Activity", "El contador de puntos es menor que 0");
            Toast.makeText(MainActivity.this, "El contador no puede ser menor a 0", Toast.LENGTH_SHORT).show();
            textView.setText("0");
        }
    }

    public void sumar1(TextView textView) {
        String scoreStr = textView.getText().toString();
        int scoreInt = Integer.parseInt(scoreStr);
        int resultado = scoreInt +=1;
        textView.setText(Integer.toString(resultado));
    }

    public void sumar2(TextView textView) {
        String scoreStr = textView.getText().toString();
        int scoreInt = Integer.parseInt(scoreStr);
        int resultado = scoreInt +=2;
        textView.setText(Integer.toString(resultado));
    }

    public void restar1(TextView textView) {
        String scoreStr = textView.getText().toString();
        int scoreInt = Integer.parseInt(scoreStr);
        int resultado = scoreInt -=1;
        textView.setText(Integer.toString(resultado));
    }


    private void openScoreActivity(String score1, String score2){
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra(SCORE_1, score1);
        intent.putExtra(SCORE_2, score2);
        startActivity(intent);
    }


}