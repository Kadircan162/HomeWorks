package com.cybertek.tests.Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxHW_WithPageSource { //test

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        System.out.println("driver.getTitle() = " + driver.getTitle());


        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");



        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();

        //List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        var checkBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));

        List<WebElement> check = new ArrayList<>(checkBoxes);

        ArrayList<WebElement> checkBoxes2 = (ArrayList<WebElement>) driver.findElements(By.cssSelector("[type='checkbox']"));


        for(WebElement each : checkBoxes){
            Assert.assertTrue(each.isSelected(), "verify all are checked");
        }

        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();

        checkBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        for(WebElement each : checkBoxes){
            Assert.assertFalse(each.isSelected(), "verify all are unchecked");
        }

        driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl09_OrderSelector")).click();
        driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete")).click();

        String s = driver.getPageSource();
        //System.out.println("s = " + s);

        Assert.assertFalse(driver.getPageSource().contains("Clare Jefferson") &&
                            driver.getPageSource().contains("770000770000"), "verify deleted item does not exist");

        Thread.sleep(3000);
        driver.quit();

    }

}
