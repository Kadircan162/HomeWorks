package com.cybertek.tests.day7_types_of_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo extends DisabledElements{

    @Test
    public void test1() throws InterruptedException {
        callChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement inputUsername = driver.findElement(By.id("username"));
        System.out.println("inputUsername.isDisplayed() = " + inputUsername.isDisplayed());
        Assert.assertFalse(inputUsername.isDisplayed(), "verify username inputBox is NOT displayed");

        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        //div[id='start']>button[class='btn btn-primary']
        startButton.click();
        Thread.sleep(7000);

        inputUsername = driver.findElement(By.id("username"));
        System.out.println("inputUsername.isDisplayed() = " + inputUsername.isDisplayed());
        Assert.assertTrue(inputUsername.isDisplayed(), "verify username inputBox is displayed");
    }
}
