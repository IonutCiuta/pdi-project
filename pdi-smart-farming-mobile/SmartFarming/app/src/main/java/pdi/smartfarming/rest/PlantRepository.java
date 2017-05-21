package pdi.smartfarming.rest;

import java.util.List;

import pdi.smartfarming.dto.Plant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */

public interface PlantRepository {
    @GET("/mobile/api/plant")
    Call<List<Plant>> getAllForUser(@Query(value = "userId") String userId);
}
