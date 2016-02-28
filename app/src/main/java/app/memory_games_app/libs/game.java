package app.memory_games_app.libs;

import android.app.Activity;
import android.content.ClipData;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
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
    public ArrayList<textobject> dtata_text = new ArrayList<>();

    public ArrayList<imageobject> images = new ArrayList<>();
    public ArrayList<imageobject> dropImages = new ArrayList<>();

    public   static ArrayList<String> rightAnswers = new ArrayList<>();
    public static ArrayList<Boolean> results = new ArrayList<>();


    HashMap<String, ArrayList<String>> Pkgs = new HashMap<>();
    Activity activity;


    public game(Activity activity) {
        this.activity = activity;
        updatePks();
    }


    public void addToText(int id) {


        textobject o = (textobject) activity.findViewById(id);
        o.setAnsid("" + id);
        dtata_text.add(o);


    }

    public void addToImages(int id) {

        imageobject o = (imageobject) activity.findViewById(id);
        o.setAnsid("" + id);
        images.add(o);


    }


    public void addTodropImages(int id) {

        imageobject o = (imageobject) activity.findViewById(id);
        dropImages.add(o);


    }


    void updatePks() {

        ArrayList<String> pkg_one = new ArrayList<String>();
        pkg_one.add("image_date_0;0");
        pkg_one.add("image_date_1;1");
        pkg_one.add("image_date_2;2");
        pkg_one.add("image_date_3;3");
        pkg_one.add("image_date_4;4");
        pkg_one.add("image_date_5;5");
        pkg_one.add("image_date_6;6");
        pkg_one.add("image_date_7;7");
        pkg_one.add("image_date_8;8");
        pkg_one.add("image_date_9;9");


        Pkgs.put("numbers", pkg_one);


        ArrayList<String> pkg_l = new ArrayList<>();
        pkg_l.add("letter_a;a");
        pkg_l.add("letter_b;b");
        pkg_l.add("letter_c;c");
        pkg_l.add("letter_d;d");
        pkg_l.add("letter_e;e");
        pkg_l.add("letter_f;f");
        pkg_l.add("letter_g;g");
        pkg_l.add("letter_h;h");
        pkg_l.add("letter_i;i");
        pkg_l.add("letter_j;j");


        Pkgs.put("letters", pkg_l);

        ArrayList<String> pkg_al = new ArrayList<>();
        pkg_al.add("aletter_1;ا");
        pkg_al.add("aletter_2;ب");
        pkg_al.add("aletter_3;ت");
        pkg_al.add("aletter_4;ث");
        pkg_al.add("aletter_5;ج");
        pkg_al.add("aletter_6;ح");
        pkg_al.add("aletter_7;خ");
        pkg_al.add("aletter_8;د");
        pkg_al.add("aletter_9;ذ");
        pkg_al.add("aletter_10;ر");


        Pkgs.put("aletters", pkg_al);


    }


    public void updateImages(String type) {


        ArrayList<String> thispkg = Pkgs.get(type);
        for (ImageView i : images) {
            Random randomizer = new Random();

            int rindex = randomizer.nextInt(thispkg.size());

            String random = thispkg.get(rindex);


            int myi = activity.getResources().getIdentifier(random.split(";")[0], "drawable", activity.getPackageName());

            rightAnswers.add(random.split(";")[1]);
            thispkg.remove(rindex);
            i.setImageResource(myi);
        }
    }


    public void fillImages(String type) {
        ArrayList<String> thispkg = Pkgs.get(type);
        int index = 0;
        for (imageobject i : images) {


            int myi = activity.getResources().getIdentifier(thispkg.get(index).split(";")[0], "drawable", activity.getPackageName());
            i.setImageResource(myi);

            i.setAnsid(thispkg.get(index).split(";")[0]);
            i.setAnsValue(thispkg.get(index).split(";")[1]);
            index++;

        }


    }

    public void updateTextResults() {
        int index = 0;

        for (textobject i : dtata_text) {

            i.setAnsid(rightAnswers.get(index));

            i.setAnsValue("" + rightAnswers.get(index));
            index++;


            i.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {


                        textobject me = (textobject) v;

                        if (me.getText().toString().equals(me.getAnsValue())) {
                            me.setBackgroundResource(R.drawable.right_text);
                            results.add(true);
                        } else {
                            results.add(false);
                            me.setBackgroundResource(R.drawable.wrong_text);


                        }
                    }
                }


            });


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
            i.setAnsValue(rightAnswers.get(index));
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

                        //  String ansid = view.getAnsValue();
                        int myi = activity.getResources().getIdentifier(view.getAnsid(), "drawable", activity.getPackageName());


                        imageobject myv = (imageobject) v;

                        myv.setBackgroundResource(myi);
                        view.setVisibility(View.INVISIBLE);
                        status = true;


                        if (myv.getAnsValue().equals(view.getAnsValue())) {
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
