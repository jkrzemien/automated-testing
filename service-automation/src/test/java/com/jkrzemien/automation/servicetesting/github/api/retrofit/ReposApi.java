package com.jkrzemien.automation.servicetesting.github.api.retrofit;

import com.jkrzemien.automation.servicetesting.github.models.Label;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

/**
 * @author Juan Krzemien
 */
public interface ReposApi {

    @POST("/repos/{userName}/{repoName}/issues/{id}/labels")
    Call<List<Label>> setLabelsByUserByRepoById(@Path("userName") String userName, @Path("repoName") String repoName, @Path("id") int id, @Body String something);

}
