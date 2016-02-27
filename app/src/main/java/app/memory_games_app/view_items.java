package app.memory_games_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import app.memory_games_app.libs.game;
import app.memory_games_app.libs.view;

public class view_items extends AppCompatActivity {
    String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_items);

        type = "numbers";



        view v = new view(this);
        v.updateFont(R.id.v_fuces_txt);
        v.updateFont(R.id.v_layout_title);


        game g = new game(this);


        g.addToImages(R.id.v_image_data_1);
        g.addToImages(R.id.v_image_data_2);
        g.addToImages(R.id.v_image_data_3);
        g.addToImages(R.id.v_image_data_4);
        g.addToImages(R.id.v_image_data_5);
        g.addToImages(R.id.v_image_data_6);
        g.addToImages(R.id.v_image_data_7);
        g.addToImages(R.id.v_image_data_8);
        g.addToImages(R.id.v_image_data_9);

        g.updateImages(type);


    }


    public void goHome(View view) {
        Intent t = new Intent(this, home.class);
        startActivity(t);

    }

    public void GoNext(View view) {

        Intent t = new Intent(this, order_images.class);

        t.putExtra("type",type);
        startActivity(t);
    }
}
