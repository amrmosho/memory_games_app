package app.memory_games_app.libs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by ismail on 2/27/2016.
 */
public class textobject extends EditText {
    private  String ansid="";
    private  String ansValue="";

    public textobject(Context context, AttributeSet attrs) {
        super(context, attrs);
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
