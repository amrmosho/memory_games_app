package app.memory_games_app.libs;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ismail on 2/26/2016.
 */
public class view {

    Activity activity;


    public view(Activity activity) {
        this.activity = activity;
    }


public void updateFont(int id){

    Typeface custom_font = Typeface.createFromAsset(activity.getAssets(),  "fonts/AGA-Cordoba-V2-Bold.ttf");



    TextView tx = (TextView)activity.findViewById(id);
    tx.setTypeface(custom_font);



}

    public void updateFont(int id ,String type){

        Typeface custom_font = Typeface.createFromAsset(activity.getAssets(),  "fonts/AGA-Cordoba-V2-Bold.ttf");

        switch (type){
            default:



        Button tx = (Button)activity.findViewById(id);
        tx.setTypeface(custom_font);
break;
        }

    }


}
