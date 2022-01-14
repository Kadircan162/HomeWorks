package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PupupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
/*
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//button[.='Confirm']")).click();
        driver.findElement(By.xpath("//button[.='No']")).click();
        Thread.sleep(2000);


 */


        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlert.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();//Alert is a class provided by selenium used to interact with js alert pup-ups which we cannot inspect
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();

        WebElement jsConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsConfirm.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();//lazy way to interact with js alert pup-up

        WebElement jsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        driver.switchTo().alert().sendKeys("Hello Js Prompt");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();


    }


}
