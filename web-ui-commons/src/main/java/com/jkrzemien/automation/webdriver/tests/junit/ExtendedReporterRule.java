package com.jkrzemien.automation.webdriver.tests.junit;

import com.jkrzemien.automation.tests.TestContext;
import com.jkrzemien.automation.webdriver.tests.UIContext;
import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static com.jkrzemien.automation.logging.Reporter.REPORTER;
import static java.lang.String.format;

/**
 * @author Juan Krzemien
 */
public class ExtendedReporterRule extends TestWatcher {

    private String testFromDescription(Description description) {
        UIContext context = (UIContext) TestContext.get();
        if (context == null) {
            throw new IllegalStateException("Test context is null!");
        }
        return format("%s -> %s - %s - %s", description.getTestClass().getSimpleName(), description.getMethodName(), context.getBrowser().name(), context.getLanguage());
    }

    @Override
    protected void failed(Throwable e, Description description) {
        REPORTER.fail(testFromDescription(description) + " failed");
        REPORTER.endTest();
    }

    @Override
    protected void succeeded(Description description) {
        REPORTER.pass(testFromDescription(description) + " passed");
        REPORTER.endTest();
    }

    @Override
    protected void starting(Description description) {
        REPORTER.startTest(testFromDescription(description), description.getMethodName());
    }

    @Override
    protected void skipped(AssumptionViolatedException e, Description description) {
        REPORTER.skip(testFromDescription(description) + " skipped");
        REPORTER.endTest();
    }

}
