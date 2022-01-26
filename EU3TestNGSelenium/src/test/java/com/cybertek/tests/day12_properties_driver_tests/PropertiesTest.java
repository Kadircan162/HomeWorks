package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {//Created PropertiesTest class just to test ConfigurationReader class

    WebDriver driver;

    @Test
    public void testProperties(){

        String browserType = ConfigurationReader.getKeyValue("browser");
        System.out.println("browserType = " + browserType);

        String testUrl = ConfigurationReader.getKeyValue("url");
        System.out.println("testUrl = " + testUrl);
    }

    @Test
    public void openBrowserWithConfig(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getKeyValue("browser"));//if the key name is not true, it returns null.
                                                                                //if there are two or more keys with the same name then it returns the last one
        driver.get(ConfigurationReader.getKeyValue("url"));
        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getKeyValue("regular_user"));
        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.getKeyValue("driver_password")+ Keys.ENTER);
    }
}
