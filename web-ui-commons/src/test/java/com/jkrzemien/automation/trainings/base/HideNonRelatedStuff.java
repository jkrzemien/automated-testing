package com.jkrzemien.automation.trainings.base;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Juan Krzemien
 */

@RunWith(MockitoJUnitRunner.class)
public abstract class HideNonRelatedStuff {

    protected final By anId = By.id("anId");
    protected final By anXPath = By.xpath("anXPath");

    @Mock
    protected WebElement anElement;

    @Mock
    protected WebElement anotherElement;

    @Mock
    protected WebDriver aDriver;

    protected List<WebElement> manyElements;

    @Before
    public void setUp() {
        this.manyElements = asList(anElement, anElement);

        WebDriver.Timeouts timeouts = mock(WebDriver.Timeouts.class);
        WebDriver.Options options = mock(WebDriver.Options.class);

        when(aDriver.manage()).thenReturn(options);
        when(options.timeouts()).thenReturn(timeouts);
        when(timeouts.implicitlyWait(anyLong(), any(TimeUnit.class))).thenReturn(null);

        // Simulates around 4 seconds of delay due to wait pooling...
        when(aDriver.getCurrentUrl()).thenReturn("", "", "", "about:blank");
        when(anElement.isDisplayed()).thenReturn(false, false, false, true);
        when(anotherElement.isDisplayed()).thenReturn(false, false, false, true);
        when(aDriver.findElement(anId)).thenReturn(null, null, null, anElement);
        when(aDriver.findElement(anXPath)).thenReturn(null);
    }

    @After
    public void tearDown() {
        reset(anElement, anotherElement, aDriver);
    }

}
