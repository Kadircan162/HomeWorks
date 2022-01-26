package com.cybertek.pagesobjectmodels;

import com.cybertek.utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsPage extends BasePage{

    //we don't need a constructor to initialize FindBy elements, we use BasePage constructor, instead as we're extending it

    public WebElement getContactEmailWebElement(String email){
        String emailXpath = "//td[text()='" + email + "']";
        return DriverSetup.getDriver().findElement(By.xpath(emailXpath));
    }

    public void goToContactDetailsByClickingEmail() throws InterruptedException {
        Thread.sleep(10);
        DriverSetup.getDriver().findElement(By.xpath("//td[text()='mbrackstone9@example.com']")).click();
    }
}
