package com.globant.bootcamp.twitter.pages;

import com.globant.bootcamp.twitter.driver.Drivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    @FindBy(id = "global-new-tweet-button")
    private WebElement newTweetButton;

    @FindBy(id ="tweet-box-home-timeline")
    private WebElement imputNewTweet;

    @FindBy(className = "tweet-action")
    private List<WebElement> buttonTweet;

    @FindBy(className = "TweetTextSize")
    private List<WebElement> tweet;

    public HomePage() {
        PageFactory.initElements(Drivers.getDriver(), this);
    }

    public boolean hasTweetButton() {
        return newTweetButton.isDisplayed() && newTweetButton.isEnabled();
    }

    /**
     * author:
     * Return string of a tweet
     * @return
     */
    public String getTweet(){

        imputNewTweet.sendKeys("test2");
        buttonTweet.get(0).click();
        Drivers.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        return tweet.get(0).getText();
    }
}
