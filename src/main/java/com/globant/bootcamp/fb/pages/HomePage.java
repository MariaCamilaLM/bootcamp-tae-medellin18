package com.globant.bootcamp.fb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObjectBase {

    @FindBy(css = "a._2s25._606w")
    private WebElement profileNameSpan;

    public Object clickOnProfileName() {
        click(profileNameSpan);
        return new Object(); // A new PO should be returned - ProfilePage (?)
    }

    public boolean hasProfileName() {
        return profileNameSpan.isDisplayed() && profileNameSpan.isEnabled();
    }
}
