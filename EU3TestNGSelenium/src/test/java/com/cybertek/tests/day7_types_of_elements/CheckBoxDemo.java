package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo extends DisabledElements{

    @Test
    public void test1(){

        callChromeDriver(); //inherited from DisabledElements class
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.cssSelector("#box1"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#box2"));

        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        System.out.println("checkbox1.isSelected() = " + checkbox2.isSelected());

        Assert.assertFalse(checkbox1.isSelected(), "verify CheckBox1 is NOT selected");
        Assert.assertTrue(checkbox2.isSelected(), "verify CheckBox2 is selected");

        //how to check checkboxes
        checkbox1.click(); //CheckBox2 is checked
        checkbox2.click(); //CheckBox2 is unchecked

        Assert.assertTrue(checkbox1.isSelected(), "verify CheckBox1 is selected");
        Assert.assertFalse(checkbox2.isSelected(), "verify CheckBox2 is NOT selected");

    }
}
