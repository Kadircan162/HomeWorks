package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement noSelectDropdown = driver.findElement(By.id("dropdownMenuLink"));
        //Select select = new Select(noSelectDropdown);//error:UnexpectedTagNameException: Element should have been "select" but was "a"

        noSelectDropdown.click();
        List<WebElement> dropdownList = driver.findElements(By.className("dropdown-item"));
        System.out.println("dropdownList.size() = " + dropdownList.size());
        int i=1;
        for (WebElement webElement : dropdownList) {
            System.out.println((i++) + ". " + webElement.getText());
        }
        dropdownList.get(2).click();

    }


}
