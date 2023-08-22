package com.example.basketballscore;

import static com.example.basketballscore.MainActivity.SCORE_1;
import static com.example.basketballscore.MainActivity.SCORE_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.basketballscore.databinding.ActivityMainBinding;
import com.example.basketballscore.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityScoreBinding binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();

        TextView resultado = binding.textView7;

        String score1 = extras.getString(SCORE_1);
        binding.textView2.setText(score1);

        String score2 = extras.getString(SCORE_2);
        binding.textView6.setText(score2);


        int score1int = Integer.parseInt(score1);
        int score2int = Integer.parseInt(score2);

        if (score1int == score2int) {
            resultado.setText("Foi empate! " + getEmojiByUnicode(0x1F605));
        }
        if (score1int > score2int) {
            resultado.setText("Ganou o equipo local! " +getEmojiByUnicode(0x1F609));
        }
        if (score1int < score2int) {
            resultado.setText("Ganou o equipo visitante! " +getEmojiByUnicode(0x1F614));
        }
    }

    //método para obtener string de iconos
    public String getEmojiByUnicode(int unicode) {

        return new String(Character.toChars(unicode));
    }
}


