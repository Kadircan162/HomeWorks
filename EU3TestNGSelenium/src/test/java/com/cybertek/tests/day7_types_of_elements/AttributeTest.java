package com.cybertek.tests.day7_types_of_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest extends DisabledElements{

    @Test
    public void test1(){
        callChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));
        System.out.println("blueRadioBtn.getAttribute(\"value\") = " + blueRadioBtn.getAttribute("value"));

        WebElement redRadioBtn = driver.findElement(By.id("red"));
        System.out.println("redRadioBtn.getAttribute(\"value\") = " + redRadioBtn.getAttribute("value"));

        System.out.println("blueRadioBtn.getAttribute(\"type\") = " + blueRadioBtn.getAttribute("type"));
        System.out.println("redRadioBtn.getAttribute(\"id\") = " + redRadioBtn.getAttribute("id"));

        System.out.println("blueRadioBtn.getAttribute(\"checked\") = " + blueRadioBtn.getAttribute("checked"));

        //calling no existing element
        System.out.println("blueRadioBtn.getAttribute(\"href\") = " + blueRadioBtn.getAttribute("href"));

        //outerHTML
        System.out.println("blueRadioBtn.getAttribute(\"outerHTML\") = " + blueRadioBtn.getAttribute("outerHTML"));

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //WebElement button2 = driver.findElement(By.cssSelector("[name='button2']"));
        WebElement button2 = driver.findElement(By.name("button2"));
        System.out.println("button2.getText() = " + button2.getText());
        button2.getAttribute("value"); //the text seen on the button element
        System.out.println("button2.getAttribute(\"outerHTML\") = " + button2.getAttribute("outerHTML"));
        System.out.println("button2.getAttribute(\"innerHTML\") = " + button2.getAttribute("innerHTML"));

        String outerHTML = button2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("Button 2"));
    }

    @Test
    public void test2(){
        callChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        WebElement inputBox = driver.findElement(By.cssSelector("input[name='firstname']"));

        inputBox.sendKeys("Hello world");

        System.out.println("inputBox.getAttribute() = " + inputBox.getAttribute("value"));
        System.out.println("inputBox.getText() = " + inputBox.getText());
        System.out.println("inputBox.getAttribute(\"innerHTML\") = " + inputBox.getAttribute("innerHTML"));
        String outerHTML = inputBox.getAttribute("outerHTML");
        System.out.println("outerHTML = " + outerHTML);
        System.out.println("inputBox.getAttribute(\"data-bv-field\") = " + inputBox.getAttribute("data-bv-field"));
    }
}
