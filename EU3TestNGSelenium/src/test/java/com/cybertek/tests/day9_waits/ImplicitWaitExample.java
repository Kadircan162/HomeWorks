package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//it will let the code continue as soon as the
        // condition is met so that it does not wait the time which we define
        //Implicit wait method is not line-specific so, you can write this statement in any method in the code since it works
        //for any findElement statement triggered in the code.
        //When a findElement cannot find the element in html code based on the locator we provide, it will call the implicitWait
        //method that we define somewhere in the code. Because of this, it WORKS ONLY for the element which is "not-part-of-the-html code"
        //until the page loads. In other word, findElements method will not call implicitWait method if it finds element--it does not
        //care if it's displayed on the webpage or not.
        //In other word, the implicitlyWait method wait for the element to appear in html code. If so, it lets findElement method
        //to find the element and do the action.

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void implicitWaitTest(){
        //There are two problems for webpage elements:
        // 1. Being a part of html but hidden on the webpage (not displayed at a certain time)--> but you can locate it on html part
        //however if we don't wait a hidden to display on the page you get the Error:  ElementNotInteractableException: element not interactable
        // 2. Not part of html until certain time () --> You cannot even locate that kind of element in html part until it displays
        //so, you get the Error: NoSuchElementException

        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        System.out.println(driver.findElement(By.xpath("//div/h4[text()='Hello World!']")).getText());//Not part of html until certain time of page load


    }



}
