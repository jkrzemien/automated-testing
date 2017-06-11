package com.jkrzemien.automation.webdriver.waiting.conditions;

import com.google.common.base.Predicate;
import com.jkrzemien.automation.functions.TriFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author Juan Krzemien
 */
public class Conditions {

    // You should define this in an external config file
    private static final long DEFAULT_TIME_OUT = 30;

    private Conditions() {
    }

    public static class Page {

        public static final Predicate<JavascriptExecutor> Loaded = js -> (boolean) (js != null ? js.executeScript("return typeof document != 'undefined' && document.readyState == 'complete';") : false);
        public static final Predicate<JavascriptExecutor> NoAjaxPending = js -> (Long) (js != null ? js.executeScript("return typeof $ != 'undefined' ? $.active : 0;") : 0) == 0;

        private Page() {
        }

    }

    public static class Locator {
        /**
         * Would be nice to be able to use Optional<WebElement> here in case element is not found
         * but FluentWait recognizes only false or null as 'keep looping' conditions...
         */
        public static final TriFunction<WebDriver, By, WebElement> Exists = (driver, by) -> {
            try {
                driver.manage().timeouts().implicitlyWait(1, SECONDS);
                return driver.findElement(by);
            } finally {
                driver.manage().timeouts().implicitlyWait(DEFAULT_TIME_OUT, SECONDS);
            }
        };
        public static final TriFunction<WebDriver, By, List<WebElement>> ManyExists = (driver, by) -> {
            try {
                driver.manage().timeouts().implicitlyWait(1, SECONDS);
                return driver.findElements(by);
            } finally {
                driver.manage().timeouts().implicitlyWait(DEFAULT_TIME_OUT, SECONDS);
            }
        };

        private Locator() {
        }

    }

    public static class Element {
        private Element() {
        }

        public static class Visibility {
            public static final Predicate<WebElement> Visible = WebElement::isDisplayed;
            public static final Predicate<WebElement> NotVisible = e -> !(e != null && e.isDisplayed());

            private Visibility() {
            }

        }

        public static class Status {
            public static final Predicate<WebElement> Enabled = WebElement::isEnabled;
            public static final Predicate<WebElement> NotEnabled = webElement -> !(webElement != null && webElement.isEnabled());

            private Status() {
            }

        }

    }

    public static class Elements {
        private Elements() {
        }

        public static class Visibility {
            public static final Predicate<List<WebElement>> Visible = i -> i != null && i.stream().allMatch(WebElement::isDisplayed);
            public static final Predicate<List<WebElement>> NotVisible = i -> i != null && i.stream().noneMatch(WebElement::isDisplayed);

            private Visibility() {
            }

        }

        public static class Status {
            public static final Predicate<List<WebElement>> Enabled = i -> i != null && i.stream().allMatch(WebElement::isEnabled);
            public static final Predicate<List<WebElement>> NotEnabled = i -> i != null && i.stream().noneMatch(WebElement::isEnabled);

            private Status() {
            }

        }

    }

    public static class Browser {
        public static final TriFunction<WebDriver, String, Boolean> ContainsInUrl = (driver, url) -> driver.getCurrentUrl().contains(url);
        public static final TriFunction<WebDriver, String, Boolean> ContainsInTitle = (driver, title) -> driver.getTitle().contains(title);

        private Browser() {
        }

    }
}