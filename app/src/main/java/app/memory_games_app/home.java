package app.memory_games_app;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/AGA-Cordoba-V2-Bold.ttf");



        TextView tx = (TextView)findViewById(R.id.welcome_txt);
        tx.setTypeface(custom_font);
        TextView numbers_bt_text = (TextView)findViewById(R.id.numbers_bt_text);
        numbers_bt_text.setTypeface(custom_font);
        TextView images_bt_text = (TextView)findViewById(R.id.images_bt_text);
        images_bt_text.setTypeface(custom_font);

    }




}
