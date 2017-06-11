package com.jkrzemien.automation.servicetesting.github.api.retrofit;

import com.jkrzemien.automation.servicetesting.github.models.Key;
import com.jkrzemien.automation.servicetesting.github.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * @author Juan Krzemien
 */
public interface UsersApi {

    @GET("/users/{userName}")
    Call<User> getUsers(@Path("userName") String userName);

    @GET("/users/{userName}/keys")
    Call<List<Key>> getUserPublicKeys(@Path("userName") String userName);

}
