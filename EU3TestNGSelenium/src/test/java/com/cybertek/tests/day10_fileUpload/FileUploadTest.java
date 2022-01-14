package com.cybertek.tests.day10_fileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void burnDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void fileUploadTest(){
        driver.get("http://practice.cybertekschool.com/upload");
        WebElement upload = driver.findElement(By.id("file-upload"));
        upload.sendKeys("C:\\Users\\arate\\Desktop\\New Text Document.txt");
        driver.findElement(By.id("file-submit")).click();

    }
}
