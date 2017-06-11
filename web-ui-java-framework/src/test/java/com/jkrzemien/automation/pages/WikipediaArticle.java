package com.jkrzemien.automation.pages;

import com.jkrzemien.automation.webdriver.tests.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

/**
 * @author Juan Krzemien
 */
public class WikipediaArticle extends PageObject<WikipediaArticle> {

    @FindBy(id = "firstHeading")
    private WebElement firstHeading;

    @FindBy(id = "mw-content-text")
    private WebElement content;

    @FindBy(id = "toc")
    private WebElement tableOfContents;

    public boolean isVisible() {
        return areVisible(Arrays.asList(firstHeading, content, tableOfContents));
    }

}
