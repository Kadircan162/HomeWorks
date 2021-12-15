package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    WebDriver driver;

    public void callChromeDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        callChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButtonGreen = driver.findElement(By.id("green"));

        Assert.assertFalse(radioButtonGreen.isEnabled(), "verify Green rb is NOT enabled");
        radioButtonGreen.click(); // no use because Green rb is disabled

        Assert.assertFalse(radioButtonGreen.isSelected(), "verify Green rb is selected");

        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test2() throws InterruptedException {
        callChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //WebElement inputText = driver.findElement(By.xpath("//form[@id='input-example']/input[@type='text']"));
        //WebElement inputText = driver.findElement(By.cssSelector("form[id='input-example']>input[type='text']"));

        WebElement inputText = driver.findElement(By.cssSelector("input[type='text']"));
        System.out.println("inputText.isEnabled() = " + inputText.isEnabled());

        Assert.assertFalse(inputText.isEnabled(), "verify the input box is NOT enabled");

        inputText.sendKeys("some message"); //throws NotInteractable error


    }
}
