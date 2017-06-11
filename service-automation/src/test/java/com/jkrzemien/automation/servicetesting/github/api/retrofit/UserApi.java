package com.jkrzemien.automation.servicetesting.github.api.retrofit;

import com.jkrzemien.automation.servicetesting.github.models.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Juan Krzemien
 */
public interface UserApi {

    @GET("/user")
    Call<User> getAuthenticatedUser();

}
