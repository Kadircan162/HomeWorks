package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
    }
    @AfterMethod
    public void burnDown(){
        Driver.closeDriver();
    }

    @Test
    public void openBrowserWithConfig(){
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("regular_user"));
        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.get("driver_password")+ Keys.ENTER);
    }
}
