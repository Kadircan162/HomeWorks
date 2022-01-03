package com.cybertek.tests.Homeworks.oscarsTasks;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/*
    Task1:
            1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
            2. Click on "Click me, to Open an alert after 5 seconds"
            3. Explicitly wait until alert is present
            4. Then handle the Javascript alert

 */

public class Task1 {

WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void handleAlert() throws InterruptedException {

        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.manage().window().maximize();
        driver.findElement(By.id("alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, 900000);
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(isAlertPresent(), "Alert pup up is not present");
        driver.switchTo( ).alert( ).accept();
        Assert.assertFalse(isAlertPresent(), "Alert pup up is still present on window, OK button does not work on Alert Pup up");

    }

    public boolean isAlertPresent() {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }

    @AfterTest
    public void burnDown() {
        driver.quit();
    }
}
