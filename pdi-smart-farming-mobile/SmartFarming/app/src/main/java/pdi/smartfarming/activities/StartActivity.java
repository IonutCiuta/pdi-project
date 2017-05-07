package pdi.smartfarming.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import pdi.smartfarming.R;

/**
 * ionutciuta24@gmail.com on 07.05.2017.
 */

public class StartActivity extends AbstractActivity {

    public StartActivity() {
        super(R.layout.activity_start);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        proceed();
    }

    private void proceed() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                next(SignInActivity.class);
            }
        }, 5000);
    }
}
