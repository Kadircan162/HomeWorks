package com.cybertek.tests.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @Test
    public void test1(){
        System.out.println("My first Test Case");
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("My second Test Case");
    }

    @Test
    public void test3(){
        System.out.println("My third Test Case");
    }

    @BeforeClass
    public void test4(){
        System.out.println("----BEFORE CLASS----");
        System.out.println("Executed one time before anything in class");
    }

    @AfterClass
    public void test5(){
        System.out.println("----AFTER CLASS----");
        System.out.println("Some reporting code here..");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("WebDriver, opening the browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing Browser, Quit");

    }

}
