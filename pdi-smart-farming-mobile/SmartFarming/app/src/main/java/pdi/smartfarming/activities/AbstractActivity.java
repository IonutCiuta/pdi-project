package pdi.smartfarming.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import pdi.smartfarming.R;

/**
 * ionutciuta24@gmail.com on 07.05.2017.
 */

public abstract class AbstractActivity extends AppCompatActivity {
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
        Toolbar mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        mToolbar.setTitle("Smart Farming");
        mToolbar.setTitleTextColor(0xFFFFFFFF);
        setSupportActionBar(mToolbar);
    }

    protected void next(Class<?> activity) {
        startActivity(new Intent(this, activity));
    }
}
