package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void openBrowserWithConfig(){
        driver.get(ConfigurationReader.getKeyValue("loginpage_url"));
        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getKeyValue("regular_username"));
        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.getKeyValue("regular_password")+ Keys.ENTER);

    }
}
