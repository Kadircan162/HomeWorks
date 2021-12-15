package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest {


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButtonBlue = driver.findElement(By.cssSelector("#blue"));
        WebElement radioButtonRed = driver.findElement(By.cssSelector("#red"));

        Assert.assertTrue(radioButtonBlue.isSelected(), "verify Blue rb is selected");
        Assert.assertFalse(radioButtonRed.isSelected(), "verify Red rb is NOT selected");

        radioButtonRed.click();

        Assert.assertFalse(radioButtonBlue.isSelected(), "verify Blue rb is NOT selected");
        Assert.assertTrue(radioButtonRed.isSelected(), "verify Red rb is selected");

        Thread.sleep(3000);
        driver.quit();
    }
}
