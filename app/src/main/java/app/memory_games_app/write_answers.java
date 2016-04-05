package app.memory_games_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.memory_games_app.libs.game;
import app.memory_games_app.libs.view;

public class write_answers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_answers);

        view v = new view(this);
        v.updateFont(R.id.w_layout_title);
        v.updateFont(R.id.w_write_txt);
        v.updateFont(R.id.w_text_data_1);
        v.updateFont(R.id.w_text_data_2);
        v.updateFont(R.id.w_text_data_3);
        v.updateFont(R.id.w_text_data_4);
        v.updateFont(R.id.w_text_data_5);
        v.updateFont(R.id.w_text_data_6);
        v.updateFont(R.id.w_text_data_7);
        v.updateFont(R.id.w_text_data_8);
        v.updateFont(R.id.w_text_data_9);








        game g = new game(this);


        g.addToText(R.id.w_text_data_1);
        g.addToText(R.id.w_text_data_2);
        g.addToText(R.id.w_text_data_3);
        g.addToText(R.id.w_text_data_4);
        g.addToText(R.id.w_text_data_5);
        g.addToText(R.id.w_text_data_6);
        g.addToText(R.id.w_text_data_7);
        g.addToText(R.id.w_text_data_8);
        g.addToText(R.id.w_text_data_9);

        g.updateTextResults();
    }

    public void GoNext(View view) {

        Intent t = new Intent(this, results.class);
        startActivity(t);
    }

    public void goHome(View view) {

        Intent t = new Intent(this, home.class);


        startActivity(t);
    }
}
