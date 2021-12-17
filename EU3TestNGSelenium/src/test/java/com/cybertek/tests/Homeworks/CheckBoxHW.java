package com.cybertek.tests.Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxHW { //test

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();

        String pageSource = driver.getPageSource();
        if(pageSource.contains("Mark Smith")){
            System.out.println(true);
        }


//        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl04_OrderSelector")).click();
//
//       // driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
//
//        Assert.assertFalse(driver.findElement(By.xpath("text()=Mark Smith")).isDisplayed());



        Thread.sleep(3000);

//
//        List<WebElement> checkout = driver.findElements(By.cssSelector("[type='checkbox']"));
//
//        for(WebElement each : checkout){
//            Assert.assertTrue(each);
//        }





//
//        Thread.sleep(4000);
//        driver.quit();


    }
}
