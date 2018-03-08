package com.globant.bootcamp.twitter.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * This is NOT the final solution.
 */
public class Drivers {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);
            //driver.addArguments("disable-infobars");
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            driver.get("https://twitter.com/");
        }
        return driver;
    }

    public static void quit(){
        driver.quit();
    }

}
