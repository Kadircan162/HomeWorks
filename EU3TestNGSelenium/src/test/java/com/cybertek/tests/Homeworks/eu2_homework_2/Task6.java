package com.cybertek.tests.Homeworks.eu2_homework_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task6 {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void burnDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void task6() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com");
        String email = driver.findElement(By.cssSelector("#email")).getText();
        System.out.println("email = " + email);
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.cssSelector("label[for='username']~input[name='full_name']")).sendKeys("Mike Smith");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[.='Sign Up']")).click();
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = driver.findElement(By.cssSelector("[name='signup_message']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage, "Expected and actual messages do not match");
        driver.switchTo().window(tabs.get(0));
        driver.navigate().refresh();

        List<WebElement> emailList = new ArrayList<>();
        while (!(emailList.size()>1)){
            emailList = new ArrayList<>(driver.findElements(By.xpath("//tr[@class]//td[@class='from']")));
        }
        System.out.println("Email from do-not-reply@practice.cybertekschool.com has been received");//verification of Step10

        driver.findElement(By.xpath("//tr[@class]//td[@class='from']")).click();
        String expectedMailFrom = "do-not-reply@practice.cybertekschool.com";
        String actualMailFrom = driver.findElement(By.cssSelector("#odesilatel")).getText();
        Assert.assertEquals(expectedMailFrom, actualMailFrom, "Mail receiving address no match");

        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = driver.findElement(By.cssSelector("#predmet")).getText();
        Assert.assertEquals(expectedSubject, actualSubject, "Mail subjects have no match");

    }

}
