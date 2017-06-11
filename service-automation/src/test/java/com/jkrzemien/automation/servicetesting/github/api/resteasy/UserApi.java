package com.jkrzemien.automation.servicetesting.github.api.resteasy;

import com.jkrzemien.automation.servicetesting.github.models.User;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

public interface UserApi {

    @GET
    @Path("/user")
    User getAuthenticatedUser(@HeaderParam("someHeader") String value);

}
