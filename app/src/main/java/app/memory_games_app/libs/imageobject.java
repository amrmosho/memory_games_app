package app.memory_games_app.libs;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import app.memory_games_app.R;

/**
 * Created by ismail on 2/26/2016.
 */
public class imageobject extends ImageView {

    private String ansid = "";
    private String ansValue = "";


    public imageobject(Context context, AttributeSet attrs) {
        super(context, attrs);

    }


    public imageobject(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public String getAnsid() {
        return ansid;
    }

    public void setAnsid(String ansid) {
        this.ansid = ansid;
    }

    public String getAnsValue() {
        return ansValue;
    }

    public void setAnsValue(String ansValue) {
        this.ansValue = ansValue;
    }
}
