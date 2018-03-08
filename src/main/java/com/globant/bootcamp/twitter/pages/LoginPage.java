package com.globant.bootcamp.twitter.pages;

import com.globant.bootcamp.twitter.driver.Drivers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    @FindBy(name = "session[username_or_email]")
    private WebElement usernameInput;

    @FindBy(name = "session[password]")
    private WebElement passwordInput;

    @FindBy(css = "input[type='submit']")
    private List<WebElement> loginButton;

    public LoginPage() {
        PageFactory.initElements(Drivers.getDriver(), this);
    }

    public HomePage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.get(0).click();
        return new HomePage();
    }

}
