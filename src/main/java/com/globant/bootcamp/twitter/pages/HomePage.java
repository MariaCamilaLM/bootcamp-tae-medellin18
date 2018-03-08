package com.globant.bootcamp.twitter.pages;

import com.globant.bootcamp.twitter.driver.Drivers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "global-new-tweet-button")
    private WebElement newTweetButton;

    public HomePage() {
        PageFactory.initElements(Drivers.getDriver(), this);
    }

    public boolean hasTweetButton() {
        return newTweetButton.isDisplayed() && newTweetButton.isEnabled();
    }
}
