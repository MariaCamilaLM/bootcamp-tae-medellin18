package com.globant.bootcamp.twitter.login;

import com.globant.bootcamp.twitter.pages.HomePage;
import com.globant.bootcamp.twitter.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.globant.bootcamp.twitter.driver.Drivers.quit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * TwitterLoginTestSuite represents a suite of tests to verify the Login functionality.
 */
public class TwitterLoginTestSuite {

    /**
     * Tear down method.
     * Close the session
     */
    @AfterMethod
    public void tearDown() {
        //quit();
    }

    @Test
    public void testSuccessfulLogin() {
        HomePage homePage = new LoginPage().login("desteban1117@gmail.com", "test123");
        assertTrue(homePage.hasTweetButton(), ":)");
    }

    @Test
    public void testSuccessfulTweet(){
        HomePage homePage = new LoginPage().login("desteban1117@gmail.com", "test123");
        assertEquals(homePage.getTweet(), "test2");
    }

}
