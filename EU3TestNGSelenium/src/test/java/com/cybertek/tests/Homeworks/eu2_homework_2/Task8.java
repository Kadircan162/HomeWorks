package com.cybertek.tests.Homeworks.eu2_homework_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task8 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void burnDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void task8() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Autocomplete")).click();
        String country = "United States of America";
        driver.findElement(By.id("myCountry")).sendKeys(country);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[value='Submit']")).click();
        String expectedResultText = "You selected: " + country;
        String actualResultText = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(expectedResultText, actualResultText, "Result texts no match");
    }
}
