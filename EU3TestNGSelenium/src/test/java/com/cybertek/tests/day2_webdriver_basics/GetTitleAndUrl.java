package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //First we should make maven (xml) setup project environment

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://practice.cydeo.com");

        System.out.println(driver.getTitle());

        String title = driver.getTitle(); //alt + enter makes a statement assigned to proper variable
        System.out.println("title = " + title); // soutv automatically set a variable into println properly

        if(title.equals("Practice")){
            System.out.println("Here the website");
        }
        driver.navigate().to("https://google.com");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
    }
}
