package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.cydeo.com");
        Thread.sleep(2000);

        driver.close(); // close current tab

        driver = new ChromeDriver(); // you need to open browser again once it's closed

        driver.get("https://practice.cydeo.com/open_new_tab");
        Thread.sleep(5000);// new tab opening time is 3 sec, so we should give a sleep
                                // more than 3 sec after opening new tab to be able to execute
                                // the next statement
        //driver.close(); //after opening the new tab, the current url closes
        driver.get("https://practice.cydeo.com/open_new_tab");
        Thread.sleep(5000);
        driver.quit(); // it closes any tabs and clear the caches
    }
}
