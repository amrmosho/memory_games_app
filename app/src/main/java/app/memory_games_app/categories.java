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
        v.updateFont(R.id.c_chose_txt);




        v.updateFont(R.id.c_gotoNumbers,"mobily");
        v.updateFont(R.id.gotoLettrs,"mobily");

        v.updateFont(R.id.c_gotoALetter,"mobily");








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
