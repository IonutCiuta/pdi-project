package pdi.smartfarming.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import pdi.smartfarming.R;
import pdi.smartfarming.dto.Plant;
import pdi.smartfarming.rest.PlantRepository;
import pdi.smartfarming.tools.Data;
import pdi.smartfarming.tools.RetrofitClient;
import pdi.smartfarming.tools.Storage;
import pdi.smartfarming.ui.Adapter;
import pdi.smartfarming.ui.VerticalDivider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ionutciuta24@gmail.com on 09.05.2017.
 */

public class PlantFragment extends AbstractFragment {

    private Adapter<Plant> mAdapter;

    public static PlantFragment instance() {
        PlantFragment fragment = new PlantFragment();
        fragment.setLayout(R.layout.fragment_list);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        setup(root);
        return root;
    }

    @Override
    protected void setup(View view) {
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.list);
        mAdapter = new Adapter<>(Data.getPlants(), R.layout.item_plant, Plant.class);
        rv.addItemDecoration(new VerticalDivider());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");

        if(Storage.containsPlants(getContext())) {
            Log.d(TAG, "Found in storage");
            List<Plant> plants = Storage.getPlants(getContext());
            mAdapter.update(plants);
        } else {
            Log.d(TAG, "Not found in storage");
            PlantRepository plantRepository = RetrofitClient.instance.create(PlantRepository.class);
            plantRepository.getAllForUser(Storage.getCurrentUser(getContext()).getId()).enqueue(
                    new Callback<List<Plant>>() {
                        @Override
                        public void onResponse(Call<List<Plant>> call, Response<List<Plant>> response) {
                            List<Plant> plants = response.body();
                            for(Plant p : plants) {
                                p.setLastUpdate(new Date());
                                p.setStatus(Plant.STATUS_OK);
                            }
                            mAdapter.update(plants);
                            Storage.savePlants(plants, getContext());
                        }

                        @Override
                        public void onFailure(Call<List<Plant>> call, Throwable t) {
                            Log.e(TAG, t.getMessage());
                            Toast.makeText(getContext(), "Error while getting data from server.", Toast.LENGTH_LONG).show();
                        }
            });
        }
    }
}
