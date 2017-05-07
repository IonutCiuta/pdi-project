package pdi.smartfarming.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * ionutciuta24@gmail.com on 07.05.2017.
 */

public abstract class AbstractActivity extends Activity {
    protected final String TAG = getClass().getSimpleName();
    protected int layout;

    public AbstractActivity(int layout) {
        this.layout = layout;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setup();
    }

    protected void setup() {
        Log.i(TAG, "setup()");
        setContentView(layout);
    }

    protected void next(Class<?> activity) {
        startActivity(new Intent(this, activity));
    }
}
