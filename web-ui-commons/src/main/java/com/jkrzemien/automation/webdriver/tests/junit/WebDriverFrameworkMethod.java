package com.jkrzemien.automation.webdriver.tests.junit;

import com.jkrzemien.automation.languages.Language;
import com.jkrzemien.automation.tests.junit.ApiFrameworkMethod;
import com.jkrzemien.automation.webdriver.browsers.Browser;
import org.junit.runners.model.FrameworkMethod;

/**
 * WebDriver aware replacement for JUnit's FrameworkMethod.
 *
 * @author Juan Krzemien
 */
class WebDriverFrameworkMethod extends ApiFrameworkMethod {

    private final Browser browser;

    /**
     * Returns a new {@code FrameworkMethod} for {@code method}
     *
     * @param method   original framework test method
     * @param browser  browser associated with this test method
     * @param language language associated with this test method
     */
    WebDriverFrameworkMethod(FrameworkMethod method, Browser browser, Language language) {
        super(method, language);
        this.browser = browser;
    }

    Browser getBrowser() {
        return browser;
    }

}
