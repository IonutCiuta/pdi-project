package pdi.smartfarming.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pdi.smartfarming.R;

/**
 * ionutciuta24@gmail.com on 09.05.2017.
 */

public class PlantFragment extends AbstractFragment {
    public static PlantFragment instance() {
        PlantFragment fragment = new PlantFragment();
        fragment.setLayout(R.layout.fragment_plants);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
