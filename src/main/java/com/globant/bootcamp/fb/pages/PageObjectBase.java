package com.globant.bootcamp.fb.pages;

import org.openqa.selenium.WebElement;

import static com.globant.bootcamp.fb.driver.Drivers.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class PageObjectBase {

    public PageObjectBase() {
        initElements(getDriver(), this);
    }

    protected WebElement type(WebElement webElement, String text) {
        webElement.sendKeys(text);
        return webElement;
    }

    protected WebElement click(WebElement webElement) {
        webElement.click();
        return webElement;
    }


}
