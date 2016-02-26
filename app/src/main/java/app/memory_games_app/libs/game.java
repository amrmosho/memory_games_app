package app.memory_games_app.libs;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by ismail on 2/26/2016.
 */
public class game {

    HashMap<String,  ArrayList<String> > Pkgs;
    ArrayList<ImageView>  images;

  void  updatePks(){

      ArrayList<String> pkg_one=new  ArrayList<String>();

      pkg_one.add("image_data_9");
      pkg_one.add("image_data_1");
      pkg_one.add("image_data_2");
      pkg_one.add("image_data_3");
      pkg_one.add("image_data_4");
      pkg_one.add("image_data_5");
      pkg_one.add("image_data_6");
      pkg_one.add("image_data_7");
      pkg_one.add("image_data_8");
      Pkgs.put("numbers",pkg_one);

  }



    public void updateImages(String type){


        ArrayList<String> thispkg=Pkgs.get(type);



for (ImageView i : images){

        Random randomizer = new Random();
        String random = thispkg.get(randomizer.nextInt(thispkg.size()));

   // i.setImageDrawable(R.de);
}






    }






}
