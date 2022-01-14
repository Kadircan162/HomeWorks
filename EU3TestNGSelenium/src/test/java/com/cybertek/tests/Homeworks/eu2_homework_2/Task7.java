package com.cybertek.tests.Homeworks.eu2_homework_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task7 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void burnDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void task7() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("File Upload")).click();

        //If the element type="file" then you can use sendKeys method to send the file path
        driver.findElement(By.id("file-upload")).sendKeys("C:\\New Text Document.txt");
        driver.findElement(By.id("file-submit")).click();

        String expectedSub = "File Uploaded!";
        String actualSub = driver.findElement(By.xpath("//*[.='File Uploaded!']")).getText();
        Assert.assertEquals(expectedSub, actualSub, "Subjects texts are not matching");

        String expectedFileName = "New Text Document.txt";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(expectedFileName, actualFileName, "File name no match");

    }
}
