package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void testSingletonExample(){

        String s = SingletonExample.getInstance();
        System.out.println(s);
        String s2 = SingletonExample.getInstance();
        System.out.println(s2);

    }

    @Test
    public void testDriver1(){
        WebDriver driver = DriverSetup.getDriver();
        System.out.println("driver = " + driver);
        //driver.get("https://www.amazon.com");

        DriverSetup.closeDriver();
    }
    @Test
    public void testDriver2(){
        DriverSetup.getDriver().get("https://www.google.com");
        WebDriver driver = DriverSetup.getDriver();
        driver.get(ConfigurationReader.getKeyValue("loginpage_url"));

    }
}
