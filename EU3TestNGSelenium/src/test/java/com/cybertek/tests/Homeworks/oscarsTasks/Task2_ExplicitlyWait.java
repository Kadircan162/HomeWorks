package com.cybertek.tests.Homeworks.oscarsTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/*
    Task2:
            1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
            2. Click on "Enable button after 10 seconds"
            3. Explicitly wait until the button is enabled
            4. Then verify the button is enabled

 */

public class Task2_ExplicitlyWait {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void isButtonEnabled() throws InterruptedException {

        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.manage().window().maximize();
        driver.findElement(By.id("enable-button")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("disable")));
        Assert.assertTrue(driver.findElement(By.id("disable")).isEnabled(), "Button is not enabled");

    }

    @AfterTest
    public void burnDown() {
        driver.quit();
    }
}
