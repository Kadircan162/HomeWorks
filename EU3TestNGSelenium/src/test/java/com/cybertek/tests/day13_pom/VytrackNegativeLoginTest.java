package com.cybertek.tests.day13_pom;

import com.cybertek.pagesobjectmodels.LoginPageOM;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VytrackNegativeLoginTest extends TestBase{

    LoginPageOM loginPageOM;

    @Test
    public void wrongPasswordTest(){ //old way of locating web elements
        loginPageOM = new LoginPageOM();
        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getKeyValue("regular_username"));
        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.getKeyValue("wrong_regularpassword"));
        driver.findElement(By.id("_submit")).click();
        String expectedUrl = ConfigurationReader.getKeyValue("loginpage_url");
        String actualUrl = driver.getCurrentUrl();
        //negative testing with wrong credentials
        Assert.assertEquals(expectedUrl, actualUrl, "Able to login with wrong password");
    }


    @Test
    public void wrongPasswordTest2(){//with the new way of locating web elements using page object model class
        loginPageOM = new LoginPageOM();
        loginPageOM.usernameInput2.sendKeys(ConfigurationReader.getKeyValue("regular_username"));
        loginPageOM.passwordInput.sendKeys(ConfigurationReader.getKeyValue("wrong_regularpassword"));
        loginPageOM.loginButton.click();
        String expectedUrl = ConfigurationReader.getKeyValue("loginpage_url");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl,"Able to login with wrong password");

    }

    @Test
    public void wrongUsernameTest(){
        loginPageOM = new LoginPageOM();
        loginPageOM.usernameInput.sendKeys(ConfigurationReader.getKeyValue("wrong_regularusername"));
        loginPageOM.passwordInput.sendKeys(ConfigurationReader.getKeyValue("regular_password"));
        loginPageOM.loginButton.click();
        String expectedUrl = ConfigurationReader.getKeyValue("loginpage_url");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "Able to login with wrong username");

    }

}

