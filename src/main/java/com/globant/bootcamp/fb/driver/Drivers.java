package com.globant.bootcamp.fb.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * This is NOT the final solution.
 */
public class Drivers {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(DesiredCapabilities.chrome());
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--incognito");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().setSize(new Dimension(1920, 1080));
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            driver.get("https://www.facebook.com/");
        }
        return driver;
    }

    public static void quit() {
        driver.quit();
    }

}
