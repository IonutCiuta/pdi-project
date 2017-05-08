package pdi.smartfarming.rest;

import pdi.smartfarming.dto.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * ionutciuta24@gmail.com on 08.05.2017.
 */

public interface UserRepository {
    @POST("signin/")
    Call<User> authenticateUser(@Body User user);
}
