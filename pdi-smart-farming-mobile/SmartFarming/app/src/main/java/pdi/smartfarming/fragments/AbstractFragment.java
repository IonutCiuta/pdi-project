package pdi.smartfarming.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import pdi.smartfarming.dto.User;

/**
 * ionutciuta24@gmail.com on 09.05.2017.
 */

public abstract class AbstractFragment extends Fragment {
    protected final String TAG = getClass().getSimpleName();
    protected int layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        if(layout == 0) {
            throw new RuntimeException("Layout should be set!");
        }
        return inflater.inflate(layout, container, false);
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    protected abstract void setup(View view);
}
