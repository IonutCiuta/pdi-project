package pdi.smartfarming.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import pdi.smartfarming.R;
import pdi.smartfarming.dto.FcmToken;
import pdi.smartfarming.dto.User;
import pdi.smartfarming.fragments.AbstractFragment;
import pdi.smartfarming.fragments.NotificationsFragment;
import pdi.smartfarming.fragments.OverviewFragment;
import pdi.smartfarming.fragments.PlantFragment;
import pdi.smartfarming.rest.UserRepository;
import pdi.smartfarming.tools.RetrofitClient;
import pdi.smartfarming.tools.Storage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ionutciuta24@gmail.com on 07.05.2017.
 */

public class MainActivity extends AbstractActivity {

    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeFragment(PlantFragment.instance());

        BottomNavigationView mBottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_notifications:
                        changeFragment(NotificationsFragment.instance());
                        break;

                    case R.id.action_plants:
                        changeFragment(PlantFragment.instance());
                        break;

                    case R.id.action_overview:
                        changeFragment(OverviewFragment.instance());
                        break;
                }

                return true;
            }
        });

        sendFcmTokenToServer();
    }

    private void changeFragment(AbstractFragment fragment) {
        getFragmentManager()
                .beginTransaction()
                .add(R.id.fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void sendFcmTokenToServer() {
        String token = Storage.getCurrentToken(this);
        User currentUser = Storage.getCurrentUser(this);
        FcmToken fcmToken = new FcmToken(currentUser.getId(), token);
        Log.i(TAG, "Sending token to server: " + fcmToken.toString());

        RetrofitClient.instance.create(UserRepository.class).addTokenForUser(fcmToken).enqueue(
                new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.d(TAG, "Token sent with success! " + response.code());
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e(TAG, t.getMessage() == null ? "Some error while sending token" : t.getMessage());
                    }
                }
        );
    }
}
