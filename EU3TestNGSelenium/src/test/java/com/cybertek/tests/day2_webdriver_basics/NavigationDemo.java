package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.navigate().to("https://www.facebook.com");

        Thread.sleep(3000); //1 sec equals to 1000 milisec
        driver.navigate().back();

        Thread.sleep(3000);
        driver.navigate().forward();

        driver.navigate().refresh();

    }
}
