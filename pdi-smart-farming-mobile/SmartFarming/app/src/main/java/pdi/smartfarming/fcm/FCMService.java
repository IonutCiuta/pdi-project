package pdi.smartfarming.fcm;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Date;
import java.util.List;
import java.util.Map;

import pdi.smartfarming.R;
import pdi.smartfarming.dto.Notification;
import pdi.smartfarming.tools.Storage;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */

public class FCMService extends FirebaseMessagingService{
    private final String TAG = getClass().getName();
    private static int MESSAGE_NOTIFICATION_ID = 1;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i(TAG, "onMessageReceived");
        handleNotification(remoteMessage);
    }

    private void handleNotification(RemoteMessage remoteMessage) {
        NotificationCompat.Builder mBuilder = getPartialBuilder(remoteMessage.getNotification());
        Log.d(TAG, remoteMessage.getData().toString());
        storeNotification(remoteMessage.getData());
        mBuilder.setSmallIcon(R.drawable.ic_local_florist_white_24dp);
        displayNotification(mBuilder.build());
    }

    private NotificationCompat.Builder getPartialBuilder(RemoteMessage.Notification notification) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext());
        mBuilder.setContentTitle(notification.getTitle());
        mBuilder.setContentText(notification.getBody());
        return mBuilder;
    }

    public void displayNotification(android.app.Notification notification) {
        NotificationManager mNotificationManager = (NotificationManager)
                getBaseContext().getSystemService(NOTIFICATION_SERVICE);

        mNotificationManager.notify(MESSAGE_NOTIFICATION_ID++, notification);
    }

    private void storeNotification(Map<String, String> data) {
        Notification.Builder builder = new Notification.Builder();
        builder.withPlantId(data.get("plantId"));
        builder.withPlantName(data.get("plantName"));
        builder.withSensorValues(data.get("h"), data.get("t"), data.get("l"));
        builder.withDate(new Date(Long.parseLong(data.get("date"))));
        builder.withStatus(data.get("status"));

        List<Notification> notifs = Storage.getNotifs(this);

        notifs.add(builder.getNotification());
        Storage.saveNotifs(notifs, this);

        Log.d(TAG, Storage.getNotifs(this).toString());
    }
}
