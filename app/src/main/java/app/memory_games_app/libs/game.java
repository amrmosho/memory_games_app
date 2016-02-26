package app.memory_games_app.libs;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import app.memory_games_app.R;

/**
 * Created by ismail on 2/26/2016.
 */
public class game {

    HashMap<String, ArrayList<String>> Pkgs = new HashMap<>();

    public ArrayList<ImageView> images = new ArrayList<>();

    public ArrayList<ImageView> dropImages = new ArrayList<>();

    Activity activity;


    public game(Activity activity) {
        this.activity = activity;
        updatePks();
    }


    public void addToImages(int id) {
        images.add((ImageView) activity.findViewById(id));

    }
    public void addTodropImages(int id) {
        dropImages.add((ImageView) activity.findViewById(id));

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
            i.setImageResource(myi);
        }
    }


    public void fillImages(String type) {
        ArrayList<String> thispkg = Pkgs.get(type);
        int index = 0;
        for (ImageView i : images) {
            int myi = activity.getResources().getIdentifier(thispkg.get(index), "drawable", activity.getPackageName());
            i.setImageResource(myi);
            index++;

        }


    }


    public void setdeage() {
        for (ImageView i : images) {


            i.setOnTouchListener(new MyTouchListener());



        }

        for (ImageView i : dropImages) {


            i.setOnDragListener(new MyDragListener());



        }


    }


    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {




                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                    view.startDrag(data, shadowBuilder, view, 0);
                    view.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }

        }
    }




    class MyDragListener implements View.OnDragListener {
       // Drawable enterShape = activity.getResources().getDrawable(R.drawable.shape_droptarget);
       // Drawable normalShape = getResources().getDrawable(R.drawable.shape);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing

                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                   // v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:

                    ImageView view = (ImageView) event.getLocalState();

                    int myi = activity.getResources().getIdentifier("image_date_0", "drawable", activity.getPackageName());
                    view.setImageResource(myi);
                    ImageView oview = (ImageView)v;

                    int myi2 = activity.getResources().getIdentifier("image_date_1", "drawable", activity.getPackageName());

                    oview.setImageResource(myi2);



                    // Dropped, reassign View to ViewGroup
                  /*
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE);*/
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                   // v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
    }
}
