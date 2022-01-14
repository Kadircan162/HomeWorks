package com.cybertek.tests.day10_fileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilePathExample {
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
    public void uploadFileDynamicPath(){
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));//device OS research
        String projectPath = System.getProperty("user.dir");//static part of filepath
        String filePathContentRoot = "src/test/resources/textFile";//dynamic part of file path
        System.out.println("projectPath = " + projectPath);
        System.out.println("filePathContentRoot = " + filePathContentRoot);
        String fullPathOfFile = projectPath + "/" + filePathContentRoot;
        driver.get("http://practice.cybertekschool.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(fullPathOfFile);
        driver.findElement(By.id("file-submit")).click();
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, "textFile", "Uploaded file is not true");
        //you need to add .txt (file type)

        filePathContentRoot = "src/test/resources/New Text Document.txt";
        fullPathOfFile = projectPath +"/"+filePathContentRoot;
        driver.get("http://practice.cybertekschool.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(fullPathOfFile);
        driver.findElement(By.id("file-submit")).click();
        actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, "New Text Document.txt", "Uploaded file is not true");

    }

}
