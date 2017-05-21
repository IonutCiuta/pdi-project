package pdi.smartfarming.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import pdi.smartfarming.R;
import pdi.smartfarming.fragments.AbstractFragment;
import pdi.smartfarming.fragments.NotificationsFragment;
import pdi.smartfarming.fragments.OverviewFragment;
import pdi.smartfarming.fragments.PlantFragment;

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
    }

    private void changeFragment(AbstractFragment fragment) {
        getFragmentManager()
                .beginTransaction()
                .add(R.id.fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}
