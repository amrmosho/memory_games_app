package app.memory_games_app.libs;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import app.memory_games_app.R;

/**
 * Created by ismail on 2/26/2016.
 */
public class game {

    public ArrayList<imageobject> images = new ArrayList<>();
    public ArrayList<imageobject> dropImages = new ArrayList<>();

    static ArrayList<String> rightAnswers = new ArrayList<>();
    HashMap<String, ArrayList<String>> Pkgs = new HashMap<>();
    Activity activity;

    public static  ArrayList<Boolean> results = new ArrayList<>();

    public game(Activity activity) {
        this.activity = activity;
        updatePks();
    }


    public void addToImages(int id) {


        imageobject o = (imageobject) activity.findViewById(id);
        o.setAnsid("" + id);
        images.add(o);


    }

    public void addToImages(int id, String ans) {


        imageobject o = (imageobject) activity.findViewById(id);
        o.setAnsid(ans);
        images.add(o);


    }

    public void addTodropImages(int id) {

        imageobject o = (imageobject) activity.findViewById(id);
        dropImages.add(o);


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
            int myi = activity.getResources().getIdentifier(random, "drawable", activity.getPackageName());

            rightAnswers.add(random);

            i.setImageResource(myi);
        }
    }


    public void fillImages(String type) {
        ArrayList<String> thispkg = Pkgs.get(type);
        int index = 0;
        for (imageobject i : images) {
            int myi = activity.getResources().getIdentifier(thispkg.get(index), "drawable", activity.getPackageName());
            i.setImageResource(myi);

            index++;

        }


    }


    public void setdeage() {
        int index = 0;
        for (ImageView i : images) {


            i.setOnTouchListener(new MyTouchListener());


        }

        for (imageobject i : dropImages) {

            i.setOnDragListener(new MyDragListener());
            i.setAnsid(rightAnswers.get(index));
            index++;

        }


    }

    View movewobj = null;

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {


            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);

                movewobj = view;
                view.setVisibility(View.INVISIBLE);

                return true;
            } else {
                return false;
            }

        }
    }

    boolean status = false;

    class MyDragListener implements View.OnDragListener {


        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();


            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    status = false;
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:


                    if (v instanceof ImageView) {

                        imageobject view = (imageobject) event.getLocalState();

                        String ansid = view.getAnsid();
                        int myi = activity.getResources().getIdentifier(ansid, "drawable", activity.getPackageName());


                        imageobject myv = (imageobject) v;

                        myv.setBackgroundResource(myi);
                        view.setVisibility(View.INVISIBLE);
                        status = true;


                        if (myv.getAnsid().equals(ansid)) {
                            Toast.makeText(activity, R.string.rightAns, Toast.LENGTH_SHORT).show();

                            myv.setImageResource(R.drawable.right_image);
                            results.add(true);
                        } else {
                            Toast.makeText(activity, R.string.wrongAns, Toast.LENGTH_SHORT).show();
                            results.add(false);

                            myv.setImageResource(R.drawable.wrong_image);

                        }
                    }

                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                    if (!status) {

                        movewobj.setVisibility(View.VISIBLE);
                    }


                default:
                    break;
            }
            return true;
        }
    }
}
