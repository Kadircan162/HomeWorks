package com.cybertek.tests.Homeworks.eu2_homework_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class Task9_10_11_12 {
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

    @DataProvider(name = "codeProvider")
    public Object[] createData1() {
        return new Object[]{"200", "301", "404", "500"};
    }

    @Test(dataProvider = "codeProvider")
    public void task9_10_11_12(String statusCode){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
        List<WebElement> codeList= driver.findElements(By.xpath("//a[contains(@href, 'status_codes/')]"));
        driver.findElement(By.cssSelector("[href='status_codes/" + statusCode + "']")).click();
        String expectedMessage = "This page returned a " + statusCode + " status code";
        String messageContainer = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(messageContainer.contains(expectedMessage), "Wrong message");

    }
}
