package com.cybertek.tests.day1_intro;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
    public static void main(String[] args) {

//        WebDriverManager.chromedriver().setup();
//        WebDriver crdriver = new ChromeDriver();
//
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver fxdriver = new FirefoxDriver();
//
//        crdriver.get("https://cydeo.com");
//        fxdriver.get("https://cydeo.com");

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");

        driver = WebDriverFactory.getDriver("firefox");
        driver.get("https://amazon.com");
    }
}
