package app.memory_games_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import app.memory_games_app.libs.game;
import app.memory_games_app.libs.view;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        getresults();

        view v = new view(this);
        v.updateFont(R.id.r_results_txt);
        v.updateFont(R.id.r_wrong_answers);
        v.updateFont(R.id.r_right_answer);
        v.updateFont(R.id.r_results_txt);

        TextView tRightAnswers = (TextView) findViewById(R.id.r_right_answer_number);
        tRightAnswers.setText(rightAnswers);


        TextView tWrongAnswer = (TextView) findViewById(R.id.r_wrong_answers_number);
        tWrongAnswer.setText(wrongAnswers);


        double full = (rightAnswers / (rightAnswers + wrongAnswers)) * 100;

        TextView tFullResults = (TextView) findViewById(R.id.r_full_results);
        tFullResults.setText(full + "%");


    }

    public void GoHome(View view) {
        Intent i = new Intent(this, home.class);
        startActivity(i);


    }

    int rightAnswers = 0;
    int wrongAnswers = 0;

    void getresults() {
        for (boolean i : game.results) {
            if (i) {
                rightAnswers++;
            } else {
                wrongAnswers++;
            }
        }
    }


}
