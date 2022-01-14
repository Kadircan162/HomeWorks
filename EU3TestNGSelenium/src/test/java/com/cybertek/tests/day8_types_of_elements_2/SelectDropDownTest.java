package com.cybertek.tests.day8_types_of_elements_2;

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

public class SelectDropDownTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("state"));
        Select select = new Select(dropdown);//We can use Select class only for dropdown elements with tagname value='select'

        System.out.println("select.getFirstSelectedOption() = " + select.getFirstSelectedOption().getText());

        List<WebElement> options = select.getOptions();//returns the list of dropdown element
        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {//select.getOptions() brings us a List of all options in dropdown list
            System.out.println("option.getText() = " + option.getText());
        }

        String expectedOption = "Select a State";
        String actualOption = select.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedOption, actualOption, "First option is wrong");

        select.selectByVisibleText("Virginia");//we cannot inspect the options inside a dropdown list with select tagname,
        // so we use methods of the Select class.

        expectedOption = "Virginia";
        select.selectByVisibleText("Virginia");
        actualOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption, actualOption, "Option " + expectedOption + " cannot be selected");

        select.selectByIndex(51);

        Thread.sleep(2000);
        select.selectByValue("AZ");//select by value (attribute --> value='AZ')



    }
}
