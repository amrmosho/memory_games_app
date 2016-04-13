package app.memory_games_app;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

import app.memory_games_app.libs.game;
import app.memory_games_app.libs.view;

public class order_images extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_images);
        game.results.clear();

        view v = new view(this);
        v.updateFont(R.id.o_order_txt);
        v.updateFont(R.id.o_layout_title);


        final ProgressBar mProgressBar =(ProgressBar) findViewById(R.id.progressBar);


        String type = getIntent().getStringExtra("type");
        game g = new game(this);


        g.addToImages(R.id.s_image_data_1);
        g.addToImages(R.id.s_image_data_2);
        g.addToImages(R.id.s_image_data_3);
        g.addToImages(R.id.s_image_data_4);
        g.addToImages(R.id.s_image_data_5);
        g.addToImages(R.id.s_image_data_6);
        g.addToImages(R.id.s_image_data_7);
        g.addToImages(R.id.s_image_data_8);
        g.addToImages(R.id.s_image_data_9);
        g.addToImages(R.id.s_image_data_10);


        g.addTodropImages(R.id.o_image_data_1);
        g.addTodropImages(R.id.o_image_data_2);
        g.addTodropImages(R.id.o_image_data_3);
        g.addTodropImages(R.id.o_image_data_4);
        g.addTodropImages(R.id.o_image_data_5);
        g.addTodropImages(R.id.o_image_data_6);
        g.addTodropImages(R.id.o_image_data_7);
        g.addTodropImages(R.id.o_image_data_8);
        g.addTodropImages(R.id.o_image_data_9);


        g.fillImages(type);

        g.setdeage();

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                mProgressBar.setProgress ((int)Math.round( millisUntilFinished * 100.0/30000));
            }
            public void onFinish() {

                goNext ();

            }
        }.start();

    }

    public void goNext(View view) {

        goNext ();

    }


    void goNext (){

        Intent t = new Intent(this, results.class);


        startActivity(t);

    }
    public void goHome(View view) {

        Intent t = new Intent(this, home.class);


        startActivity(t);
    }
}

