package app.memory_games_app.libs;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import app.memory_games_app.R;

/**
 * Created by ismail on 2/26/2016.
 */
public class game {

    HashMap<String, ArrayList<String>> Pkgs  = new HashMap<> ();;
   public ArrayList<ImageView> images = new ArrayList<> ();;

    Activity activity;


    public game(Activity activity) {
        this.activity = activity;
        updatePks();
    }



    public void addToImages(int id) {
        images.add((ImageView) activity.findViewById(id));

    }


    void updatePks() {

        ArrayList<String> pkg_one = new ArrayList<String>();
        pkg_one.add("image_date_0");
        pkg_one.add("image_date_1");
        pkg_one.add("image_date_2");
        pkg_one.add("image_date_3");
        pkg_one.add("image_date_4");
        pkg_one.add("image_date_5");
        pkg_one.add("image_date_6");
        pkg_one.add("image_date_7");
        pkg_one.add("image_date_8");
        pkg_one.add("image_date_9");
        Pkgs.put("numbers", pkg_one);

    }


    public void updateImages(String type) {



        ArrayList<String> thispkg = Pkgs.get(type);
        for (ImageView i : images) {
            Random randomizer = new Random();
            String random = thispkg.get(randomizer.nextInt(thispkg.size()));
            String url = random;


            int myi = activity.getResources().getIdentifier(random, "drawable", activity.getPackageName());

            i.setImageResource(myi);

        }


    }


}
