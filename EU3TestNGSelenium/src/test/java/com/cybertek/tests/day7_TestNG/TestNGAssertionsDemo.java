package com.cybertek.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void openBrowser(){
        System.out.println("Open the browser");
    }

    @Test
    public void test1(){
        System.out.println("First assertion");
        Assert.assertEquals("title", "title");

        System.out.println("Second assertion");
        Assert.assertEquals("urL", "url");

        System.out.println("Third assertion");
        Assert.assertEquals("toyota", "toyota");

    }

    @Test
    public void test2(){
        System.out.println("Second assertion");
        Assert.assertEquals("apple", "apple");
    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("Close the browser");
    }
}
