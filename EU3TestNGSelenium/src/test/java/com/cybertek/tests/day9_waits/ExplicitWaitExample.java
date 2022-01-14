package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {

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

    @Ignore
    @Test
    public void explicitWaitTest(){
        //There are two problems for webpage elements:
        // 1. Being a part of html but hidden on the webpage (not displayed at a certain time)--> but you can locate it on html part
        //however if we don't wait a hidden to display on the page you get the Error:  ElementNotInteractableException: element not interactable
        // 2. Not part of html until certain time () --> You cannot even locate that kind of element in html part until it displays
        //so, you get the Error: NoSuchElementException


        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start>button[class='btn btn-primary']")).click();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//interestingly the implicitlyWait method works here although it should not
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));//By visibilityOfElementLocated() method
        //you don't need to write driver.findElement() in parentheses but just By.locatorMethod --> it takes "By locator"
        //***> wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#username"))));//visibilityOf() method takes
        //WebElement element itself

        driver.findElement(By.cssSelector("#username")).sendKeys("Hello");
    }

    @Test
    public void explicitWaitTest2(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.cssSelector("#input-example>button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 6);//Used to explicitly wait --> It's used for the elements which is
        //already part of the html code and will appear or will be enabled or clickable after some time (based on the web page condition)
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-example>input")));
        driver.findElement(By.cssSelector("#input-example>input")).sendKeys("Explicitly waiting here!");

    }
}
