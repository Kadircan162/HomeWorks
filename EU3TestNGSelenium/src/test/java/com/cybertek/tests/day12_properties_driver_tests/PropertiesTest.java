package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    WebDriver driver;

    @Test
    public void testProperties(){

        String browserType = ConfigurationReader.get("browser");
        System.out.println("browserType = " + browserType);

        String testUrl = ConfigurationReader.get("url");
        System.out.println("testUrl = " + testUrl);
    }

    @Test
    public void openBrowserWithConfig(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));//if the key name is not true, it returns null.
                                                                                //if there are two or more keys with the same name then it returns the last one
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("regular_user"));
        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.get("driver_password")+ Keys.ENTER);
    }
}
