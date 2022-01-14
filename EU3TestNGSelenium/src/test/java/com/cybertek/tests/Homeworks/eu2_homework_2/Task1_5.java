package com.cybertek.tests.Homeworks.eu2_homework_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Task1_5 {
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
    public void task1(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[placeholder='MM/DD/YYYY']")).sendKeys("wrong_dob");
        Assert.assertTrue(driver.findElement(By.xpath("//small[.='The date of birth is not valid']")).isDisplayed(), "Warning" +
                "did not display");

    }

    @Test
    public void task2(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("#inlineCheckbox3")).isDisplayed(), "Checbox1 isn't displayed");

    }

    @Test
    public void task3(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("d");
        boolean isDisplayed = driver.findElement(By.xpath("//input[@name='firstname']/..//small[2]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "The warning text is not displayed");

        String expectedText = "first name must be more than 2 and less than 64 characters long";
        String actualText = driver.findElement(By.xpath("//input[@name='firstname']/..//small[2]")).getText();

        Assert.assertEquals(expectedText, actualText, "Expected and actual texts are not matching");

    }

    @Test
    public void task4(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//input[@name='lastname'][@placeholder='last name']")).sendKeys("d");
        boolean isDisplayed = driver.findElement(By.xpath("//input[@name='lastname']/../small[2]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "The warning text is not displayed");

        String expectedText = "The last name must be more than 2 and less than 64 characters long";
        String actualText = driver.findElement(By.xpath("//input[@name='lastname']/../small[2]")).getText();
        Assert.assertEquals(expectedText, actualText, "Expected and actual texts are not matching");

    }

    @Test
    public void task5(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Mike");
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Smith");
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("MSmith");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("msmith@practice.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("12345678");
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("811-545-2547");
        driver.findElement(By.cssSelector("[name='gender'][value='male']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("4/18/1985");

        WebElement dropDown1 = driver.findElement(By.cssSelector("[name='department']"));
        Select selectDropdown = new Select(dropDown1);
        List<WebElement> dropDownList = selectDropdown.getOptions();
        System.out.println("dropDownList.size() = " + dropDownList.size());
        selectDropdown.selectByVisibleText("Accounting Office");

        WebElement dropDown2 = driver.findElement(By.xpath("//option[.=' Select job type']/../../select[@name='job_title']"));
        selectDropdown = new Select(dropDown2);
        dropDownList = selectDropdown.getOptions();
        System.out.println("dropDownList.size() = " + dropDownList.size());
        selectDropdown.selectByIndex(6);//Scrum Master
        driver.findElement(By.id("inlineCheckbox2")).click();//Java checkbox
        driver.findElement(By.id("wooden_spoon")).click();//Submit button

        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = driver.findElement(By.xpath("//h4[contains(text(),'Well done!')]/following-sibling::p")).getText();
        Assert.assertEquals(expectedMessage, actualMessage, "Actual and expected messages are no matching");

    }

}
