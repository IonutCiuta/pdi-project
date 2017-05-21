package pdi.smartfarming.fcm;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */
public class FCMIDService extends FirebaseInstanceIdService {
    private final String TAG = getClass().getName();

    @Override
    public void onTokenRefresh() {
        Log.w(TAG, "onTokenRefresh");
        Intent intent = new Intent(this, FCMRegistrationService.class);
        startService(intent);
    }
}
