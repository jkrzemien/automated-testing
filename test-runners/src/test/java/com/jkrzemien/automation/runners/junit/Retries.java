package com.jkrzemien.automation.runners.junit;

import com.jkrzemien.automation.runners.junit.retry.Retry;
import com.jkrzemien.automation.runners.junit.retry.RetryRule;
import org.junit.Rule;
import org.junit.Test;
import org.testng.Assert;

/**
 * @author Juan Krzemien
 */
public class Retries {

    @Rule
    public RetryRule rule = new RetryRule(3);

    @Test
    @Retry
    public void testToRetry() {
        Assert.assertEquals(1, 0);
    }

}
