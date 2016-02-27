package app.memory_games_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.memory_games_app.libs.game;
import app.memory_games_app.libs.view;

public class order_images extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_images);


        view v = new view(this);
        v.updateFont(R.id.o_order_txt);
        v.updateFont(R.id.o_layout_title);




        String type = getIntent().getStringExtra("type");
        game g = new game(this);


        g.addToImages(R.id.s_image_data_1,"image_date_0");
        g.addToImages(R.id.s_image_data_2,"image_date_1");
        g.addToImages(R.id.s_image_data_3,"image_date_2");
        g.addToImages(R.id.s_image_data_4,"image_date_3");
        g.addToImages(R.id.s_image_data_5,"image_date_4");
        g.addToImages(R.id.s_image_data_6,"image_date_5");
        g.addToImages(R.id.s_image_data_7,"image_date_6");
        g.addToImages(R.id.s_image_data_8,"image_date_7");
        g.addToImages(R.id.s_image_data_9,"image_date_8");
        g.addToImages(R.id.s_image_data_10,"image_date_9");


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
    }
}
