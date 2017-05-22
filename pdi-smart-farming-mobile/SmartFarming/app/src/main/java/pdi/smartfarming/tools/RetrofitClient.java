package pdi.smartfarming.tools;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ionutciuta24@gmail.com on 08.05.2017.
 */

public class RetrofitClient {

    public static final Retrofit instance;

    static {
        instance = new Retrofit.Builder()
                .baseUrl("http://192.168.0.100:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
