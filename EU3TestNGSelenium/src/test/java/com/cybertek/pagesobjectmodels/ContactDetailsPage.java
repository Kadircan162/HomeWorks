package com.cybertek.pagesobjectmodels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDetailsPage extends BasePage{

    @FindBy(className = "user-name")
    public WebElement fullName;

    @FindBy(className = "phone")
    public WebElement phoneNumber;

    @FindBy(className = "email")
    public WebElement email;


    public WebElement getFullName(){
        return fullName;
    }

    public WebElement getPhoneNumber(){
        return phoneNumber;
    }

    public WebElement getEmail(){
        return email;
    }
}
