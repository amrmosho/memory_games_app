package app.memory_games_app;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import app.memory_games_app.libs.view;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        view v = new view(this);


        v.updateFont(R.id.welcome_txt);
        v.updateFont(R.id.numbers_bt_text, "mobily");
        v.updateFont(R.id.images_bt_text, "mobily");


    }


    public void goToMoving(View view) {

        Intent t = new Intent(this, categories.class);


        t.putExtra("gametype", "moving");





        startActivity(t);
    }


    public void goToRwiteing(View view) {


        Intent t = new Intent(this, categories.class);
        t.putExtra("gametype", "writeing");
        startActivity(t);
    }
}
