package app.memory_games_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.memory_games_app.libs.view;

public class categories extends AppCompatActivity {
    String gametype = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);


        gametype = getIntent().getStringExtra("gametype");


        view v = new view(this);
        v.updateFont(R.id.c_layout_title);
        v.updateFont(R.id.c_gotoNumbers,"button");
        v.updateFont(R.id.gotoLettrs,"button");

        v.updateFont(R.id.c_gotoALetter,"button");








    }

    public void gotoNumbers(View view) {

        Intent t = new Intent(this, view_items.class);
        t.putExtra("gametype", gametype);
        t.putExtra("type", "numbers");

        startActivity(t);

    }

    public void goHome(View view) {

        Intent t = new Intent(this, home.class);


        startActivity(t);
    }

    public void gotoLettrs(View view) {
        Intent t = new Intent(this, view_items.class);
        t.putExtra("gametype", gametype);
        t.putExtra("type", "letters");

        startActivity(t);
    }

    public void gotoALetter(View view) {

        Intent t = new Intent(this, view_items.class);
        t.putExtra("gametype", gametype);
        t.putExtra("type", "aletters");

        startActivity(t);
    }
}
