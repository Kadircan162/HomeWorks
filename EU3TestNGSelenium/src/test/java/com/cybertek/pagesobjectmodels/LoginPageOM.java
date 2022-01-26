package com.cybertek.pagesobjectmodels;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.DriverSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPageOM{

    public LoginPageOM(){
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }

    //WebElement usernameInput = driver.findElement(By.id("prependedInput")); --> is represented with two lines below
    @FindBy(id = "prependedInput") //@FindBy comes from selenium annotation package
    public WebElement usernameInput;


    @FindAll({
            @FindBy(id="prependedInput"),
            @FindBy(name="_username"),
            @FindBy(css="[placeholder='Username or Email']")
    })
    public WebElement usernameInput2;//brings up which locator is correct inside @FindAll method seperated with 'OR'


    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBys({@FindBy(id="prependedInput2"), @FindBy(name="_password"), @FindBy(css = "[placeholder='Password']")})
    public WebElement passwordInput2;//brings up which locator is correct inside @FindAll method separated with 'AND'

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> buttonList;//keeps all the elements with the same locator in a List


    public void loginAsStoreManager(){
        String username = ConfigurationReader.getKeyValue("storemanager_username");
        String password = ConfigurationReader.getKeyValue("storemanager_password");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }




}
