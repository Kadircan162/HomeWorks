package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssLocator {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement dontClickButton = driver.findElement(By.cssSelector("#disappearing_button"));
        System.out.println(dontClickButton.getText());

        dontClickButton.click();

        System.out.println(driver.findElement(By.cssSelector("#result")).getText());

        driver.quit();

    }
}
