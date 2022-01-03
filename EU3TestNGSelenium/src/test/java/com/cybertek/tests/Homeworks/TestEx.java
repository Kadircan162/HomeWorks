package com.cybertek.tests.Homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestEx {

    @Test
    public void test(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement inputFullNameBox = driver.findElement(By.name("wooden_spoon"));

        //inputFullNameBox.sendKeys("Mike");

        System.out.println("inputNumbersBox.getText() = " + inputFullNameBox.getAttribute("value"));

        System.out.println("driver.findElement(By.tagName('h2')).getText() = " + driver.findElement(By.tagName("h2")).getText());



    }



}
