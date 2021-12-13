package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        //lazy way to open an url
        //WebDriverFactory.getDriver("chrome").get("http://practice.cybertekschool.com/sign_up");
        Thread.sleep(1000);
        driver.findElement(By.className("nav-link")).click();
        Thread.sleep(1000);

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

//        WebElement multipleButtonsText = driver.findElement(By.className("h3"));
//        System.out.println("multipleButtonsText.getText() = " + multipleButtonsText.getText());
        //lazy way
        System.out.println(driver.findElement(By.className("h3")).getText());
        driver.quit();

    }
}
