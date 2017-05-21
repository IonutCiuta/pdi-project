package pdi.smartfarming.fcm;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import pdi.smartfarming.dto.FcmToken;
import pdi.smartfarming.dto.User;
import pdi.smartfarming.tools.Storage;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */
public class FCMRegistrationService extends IntentService {
    private final String TAG = getClass().getName();
    private static final String name = "REGISTRATION_SERVICE";

    public FCMRegistrationService() {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        FirebaseInstanceId instanceId = FirebaseInstanceId.getInstance();
        String token = instanceId.getToken();
        Log.i(TAG, "FCM REG. TOKEN: " + token);
        Storage.saveCurrentToken(token, this);
    }
}
