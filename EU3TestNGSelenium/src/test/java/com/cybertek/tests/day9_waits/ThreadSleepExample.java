package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");
        Thread.sleep(6000);//Thread class comes from Java. It doesn't check any condition (page load, element display time etc.)
        //so it forcefully waits given seconds and lets the code executes after the time finished.
        //Second reason why we should not use Thread.sleep is that it makes testing too slow with unnecessary waits.
        driver.findElement(By.id("username")).sendKeys("MikeSmith");

    }
}
