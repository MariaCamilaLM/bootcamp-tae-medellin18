package com.globant.bootcamp.fb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 */
public class LoginPage extends PageObjectBase {

    @FindBy(name = "email")
    private WebElement usernameInput;

    @FindBy(name = "pass")
    private WebElement passwordInput;

    @FindBy(css = "input[type='submit']")
    private WebElement loginButton;

    /**
     * @param username
     * @param password
     * @return
     */
    public HomePage login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
        return new HomePage();
    }

}
