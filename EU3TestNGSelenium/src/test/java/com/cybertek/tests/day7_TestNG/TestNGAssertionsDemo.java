package com.cybertek.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGAssertionsDemo {

    @BeforeClass
    public void testBefore(){
        System.out.println("----BEFORE CLASS----");
        System.out.println("Executed one time before anything in class");
    }

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
        System.out.println("Fourth assertion");
        Assert.assertEquals("apple", "apple");
    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("Close the browser");
    }

    @AfterClass
    public void testAfterClass(){
        System.out.println("----AFTER CLASS----");
        System.out.println("Some reporting code here..");
    }
}
