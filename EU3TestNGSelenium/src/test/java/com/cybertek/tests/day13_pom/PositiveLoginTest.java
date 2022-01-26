package com.cybertek.tests.day13_pom;

import com.cybertek.pagesobjectmodels.LoginPageOM;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    LoginPageOM loginPageOM = new LoginPageOM();

    @Test
    public void correctCredentialsForRegularUser(){
        loginPageOM.usernameInput.sendKeys(ConfigurationReader.getKeyValue("regular_username"));
        loginPageOM.passwordInput.sendKeys(ConfigurationReader.getKeyValue("regular_password"));
        loginPageOM.loginButton.click();

        String expectedUrl = ConfigurationReader.getKeyValue("dashboard_url");
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl, "Not able to login with valid credentials");
    }

    @Test
    public void correctCredentialsForDriver(){

        loginPageOM.usernameInput.sendKeys(ConfigurationReader.getKeyValue("driver_username"));
        loginPageOM.passwordInput.sendKeys(ConfigurationReader.getKeyValue("driver_password"));
        loginPageOM.loginButton.click();

        String expectedUrl = ConfigurationReader.getKeyValue("dashboard_url");
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl, "Not able to login with valid credentials");
    }

    @Test
    public void loginAsStoreManager(){
        //old way of using LoginPage Object Model
        /*
        loginPageOM.usernameInput.sendKeys(ConfigurationReader.getKeyValue("storemanager_username"));
        loginPageOM.passwordInput.sendKeys(ConfigurationReader.getKeyValue("storemanager_password"));
        loginPageOM.loginButton.click();
        */

        loginPageOM.loginAsStoreManager();

        String expectedUrl = ConfigurationReader.getKeyValue("dashboard_url");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "Could not login as Store Manager");

    }

    @Test
    public void test(){
        System.out.println(loginPageOM.loginButton.getAttribute("name"));
        System.out.println(loginPageOM.passwordInput.getCssValue("color"));
        System.out.println(loginPageOM.usernameInput.getCssValue("color"));
    }

}
