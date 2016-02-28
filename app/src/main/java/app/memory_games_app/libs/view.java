package app.memory_games_app.libs;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
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


    public void updateFont(int id) {

        Typeface custom_font = Typeface.createFromAsset(activity.getAssets(), "fonts/AGA-Cordoba-V2-Bold.ttf");


        View o = (View) activity.findViewById(id);

        if (o instanceof TextView) {

            TextView tx = (TextView) o;
            tx.setTypeface(custom_font);
        } else if (o instanceof Button) {
            Button tx = (Button) o;
            tx.setTypeface(custom_font);

        }


    }


    public void updateFont(int id, String font) {


        Typeface custom_font = Typeface.createFromAsset(activity.getAssets(), "fonts/" + font + ".ttf");


        View o = (View) activity.findViewById(id);

        if (o instanceof TextView) {

            TextView tx = (TextView) o;
            tx.setTypeface(custom_font);
        } else if (o instanceof Button) {
            Button tx = (Button) o;
            tx.setTypeface(custom_font);

        }

    }
}

