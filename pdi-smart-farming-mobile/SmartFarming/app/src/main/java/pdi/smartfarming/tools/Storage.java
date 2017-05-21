package pdi.smartfarming.tools;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import pdi.smartfarming.dto.FcmToken;
import pdi.smartfarming.dto.Plant;
import pdi.smartfarming.dto.User;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */

public class Storage {
    private static final String KEY_SP = "PDI";
    private static final String KEY_USER = "key_user";
    private static final String KEY_TOKEN = "key_token";
    private static final String KEY_PLANT = "key_plant";

    private static Gson gson = new Gson();

    private static SharedPreferences getStorage(Context context) {
        return context.getSharedPreferences(KEY_SP, Context.MODE_PRIVATE);
    }

    public static User getCurrentUser(Context context) {
        return gson.fromJson(getStorage(context).getString(KEY_USER, null), User.class);
    }

    public static void saveCurrentUser(User user, Context context) {
        getStorage(context).edit().putString(KEY_USER, gson.toJson(user)).apply();
    }

    public static String getCurrentToken(Context context) {
        return getStorage(context).getString(KEY_TOKEN, null);
    }

    public static void saveCurrentToken(String token, Context context) {
        getStorage(context).edit().putString(KEY_TOKEN, token).apply();
    }

    public static List<Plant> getPlants(Context context) {
        return Arrays.asList(gson.fromJson(getStorage(context).getString(KEY_PLANT, null), Plant[].class));
    }

    public static void savePlants(List<Plant> plants, Context context) {
        getStorage(context).edit().putString(KEY_PLANT, gson.toJson(plants)).apply();
    }

    public static boolean containsUser(Context context) {
        return contains(KEY_USER, context);
    }

    public static boolean containsPlants(Context context) {
        return contains(KEY_PLANT, context);
    }

    public static boolean containsToken(Context context) {
        return contains(KEY_TOKEN, context);
    }

    private static boolean contains(String key, Context context) {
        return getStorage(context).contains(key);
    }
}
