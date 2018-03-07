package com.globant.bootcamp.twitter.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * TwitterLoginTestSuite represents a suite of tests to verify the Login functionality.
 */
public class TwitterLoginTestSuite {

    /**
     * The global {@link WebElement} instance (shared by all test methods).
     */
    private WebDriver driver;

    /**
     * Set up method.
     * 1. Sets system properties for the selected driver binaries
     * 2. Creates an instance of {@link ChromeDriver}, the session is created (client/server)
     * 3. Manages the window resolution by maximizing the browser
     * 4. Sets implicit, page load and script timeouts.
     * 5. Navigates/Open the https://twitter.com/ URL
     */
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.get("https://twitter.com/");
    }

    /**
     * Tear down method.
     * Close the session
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSuccessfulLogin() {
        // 1. Locate the WebElements by Locators
        WebElement usernameInput = driver.findElement(By.name("session[username_or_email]"));
        WebElement passwordInput = driver.findElement(By.name("session[password]"));
        WebElement loginButton = driver.findElements(By.cssSelector("input[type='submit']")).get(0);

        // Type username and password, and click on the login button
        usernameInput.sendKeys("damianmoga@gmail.com");
        passwordInput.sendKeys("1q2w3e4r");
        loginButton.click();

        // A simple assertion to verify that the user is logged in
        WebElement newTweetButton = driver.findElement(By.id("global-new-tweet-button"));
        Assert.assertTrue(newTweetButton.isDisplayed());
        Assert.assertTrue(newTweetButton.isEnabled());
    }

}
