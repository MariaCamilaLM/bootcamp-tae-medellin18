package com.globant.bootcamp.fb.login;

import com.globant.bootcamp.fb.pages.HomePage;
import com.globant.bootcamp.fb.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.globant.bootcamp.fb.driver.Drivers.quit;
import static org.testng.Assert.assertTrue;

/**
 * FacebookLoginTestSuite represents a suite of tests to verify the Login functionality.
 */
public class FacebookLoginTestSuite {

    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    /**
     * Tear down method.
     * Close the session
     */
    @AfterMethod
    public void tearDown() {
        quit();
    }

    @Test
    public void testSuccessfulLogin() {
        HomePage homePage = new LoginPage().login(USERNAME, PASSWORD);
        assertTrue(homePage.hasProfileName(), ":)");
    }

}
