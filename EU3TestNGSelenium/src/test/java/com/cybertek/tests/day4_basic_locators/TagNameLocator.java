package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.tagName("input"));
        fullName.sendKeys("Mike Smith");

        driver.findElement(By.name("email")).sendKeys("msmith@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(1000);
        driver.quit();

    }


}
