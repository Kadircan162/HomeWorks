package com.cybertek.tests.day3_webelement_intro;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLNotChanged {

    public static void main(String[] args) {
        /*Verify confirmation message
        * open chrome browser
        * go to http://practice.cybertekschool.com/forgot_password Links to an  external site.
        * enter any email
        * verify that email is displayed in the input box
        * click on Retrieve password
        * verify that confirmation message says 'Your e-mail's been sent!'
        */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //click on Retrieve password button --> locators
        String expectedUrl = driver.getCurrentUrl();

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        String actualUrl = driver.getCurrentUrl();
        //verify that url did not change after clicking on retrieve button
        if(expectedUrl.equals(actualUrl)) System.out.println("PASS");
        else System.out.println("FAIL");

        driver.quit(); //close your browser




    }
}
