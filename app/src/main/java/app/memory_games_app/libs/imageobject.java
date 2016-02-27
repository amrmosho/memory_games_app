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

    private int mCachedResourceId = 0;
private  String ansid="";


    public imageobject(Context context, AttributeSet attrs) {
        super(context, attrs);

        mCachedResourceId = attrs.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", mCachedResourceId);

    }


    public imageobject(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mCachedResourceId = attrs.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", mCachedResourceId);
    }


    public int getDefaultResourceId() {
        return mCachedResourceId;
    }

    public void resetToDefault() {
        setImageResource(mCachedResourceId);
    }

    public String getAnsid() {
        return ansid;
    }

    public void setAnsid(String ansid) {
        this.ansid = ansid;
    }
}
