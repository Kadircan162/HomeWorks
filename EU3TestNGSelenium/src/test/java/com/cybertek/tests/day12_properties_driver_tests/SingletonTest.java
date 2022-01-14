package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.Driver;
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
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.amazon.com");

        //Driver.closeDriver();
    }
    @Test
    public void testDriver2(){

        Driver.getDriver().get("https://www.google.com");

    }
}
