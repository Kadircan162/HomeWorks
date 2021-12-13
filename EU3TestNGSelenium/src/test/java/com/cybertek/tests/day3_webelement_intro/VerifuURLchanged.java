package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifuURLchanged {

        /* Verify URL changed
        open chrome browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to http://practice.cybertekschool.com/email_sent
        */
        public static void main(String[] args) throws InterruptedException {

            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.get("http://practice.cybertekschool.com/forgot_password");
            WebElement emailInputBox = driver.findElement(By.name("email"));

            Faker faker = new Faker();
            emailInputBox.sendKeys(faker.internet().safeEmailAddress());
            Thread.sleep(5000);

            WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
            retrievePasswordButton.click();
            Thread.sleep(3000);
            String expectedUrl = "http://practice.cybertekschool.com/email_sentce";
            String actualUrl = driver.getCurrentUrl();
            if(expectedUrl.equals(actualUrl)){
                System.out.println("PASS");
            }
            else{
                System.out.println("FAIL");
                System.out.println("actualUrl = " + actualUrl);
                System.out.println("expectedUrl = " + expectedUrl);
            }



            Thread.sleep(3000);
            driver.quit();


        }





}
