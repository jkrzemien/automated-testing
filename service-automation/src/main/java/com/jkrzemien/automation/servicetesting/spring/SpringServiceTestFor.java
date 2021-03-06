package com.jkrzemien.automation.servicetesting.spring;

import com.jkrzemien.automation.logging.Logging;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import static java.lang.String.format;

/**
 * @author Juan Krzemien
 */
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class SpringServiceTestFor<T> implements Logging {

    @Autowired
    private Retrofit client;

    @SuppressWarnings("unchecked")
    private Class<T> getApiType() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    /**
     * Helper method to actually execute Retrofit calls.
     * I don't like polluting tests with .execute() invocations or try/catch blocks.
     *
     * @param method Retrofit interface to call
     * @param <K>    Retrofit interface return type
     * @return Retrofit's Response of type K
     */
    protected <K> Response<K> call(Call<K> method) {
        try {
            getLogger().info(format("Invoking API: %s", method.request().toString()));
            return method.execute();
        } catch (IOException e) {
            getLogger().error(format("Could not perform service call for: %s", method.request().toString()), e);
        }
        return null;
    }

    protected T api() {
        return client.create(getApiType());
    }

}

