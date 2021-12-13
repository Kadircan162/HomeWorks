package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
     /*
        Verify confirmation message:
        - open chrome browser
        - go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        - enter any email
        - verify that email is displayed in the input box
        - click on Retrieve password
        - verify that confirmation message says 'Your e-mail's been sent!'
     */
     public static void main(String[] args) throws InterruptedException {
         WebDriver driver = WebDriverFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com/forgot_password");

         WebElement emailInputBox = driver.findElement(By.name("email"));

//         Faker faker = new Faker();
//         emailInputBox.sendKeys(faker.internet().safeEmailAddress());
//         Thread.sleep(3000);
         String expectedEmail = "mike@smith.com";
         emailInputBox.sendKeys(expectedEmail);

         String actualEmail = emailInputBox.getAttribute("value");

         if(actualEmail.equals(expectedEmail)){
             System.out.println("verify that email is displayed in the input box is PASS");
         }else{
             System.out.println("verify that email is displayed in the input box is FAIL");
             System.out.println("expectedEmail = " + expectedEmail);
             System.out.println("actualEmail = " + actualEmail);
         }



//         String[] emailPart1 = actualEmail.split("@");
//         String emailPart2 = actualEmail.substring(actualEmail.length()-4);
//
//         if(emailPart1.length == 2 && emailPart2.equals(".com")){
//             System.out.println("verify that email is displayed in the input box is PASS");
//         }else{
//             System.out.println("verify that email is displayed in the input box is FAIL");
//             System.out.println("actualEmail = " + actualEmail);
//         }

         driver.findElement(By.id("form_submit")).click();

         String expectedText = "Your e-mail's been sent!";
         WebElement sentText = driver.findElement(By.name("confirmation_message"));
         String actualText = sentText.getText();
         System.out.println("Actual sent text: " + actualText);

         if(expectedText.equals(actualText)){
             System.out.println("Verify confirmation message PASS");
         }else{
             System.out.println("Verify that confirmation message FAIL");
             System.out.println("expectedTest = " + expectedText);
             System.out.println("actualText = " + actualText);

         }
         Thread.sleep(3000);
         driver.quit();

     }

}
