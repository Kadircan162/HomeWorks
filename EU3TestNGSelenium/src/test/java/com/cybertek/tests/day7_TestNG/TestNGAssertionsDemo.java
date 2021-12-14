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

    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";
        Assert.assertEquals(actualTitle.substring(0, 3), expectedTitle);
        System.out.println("TEST3: PASS");
        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verify title starts with Cyb");
        System.out.println("TEST3: PASS");

        //Here no difference between two assert statements as both verify if actualTitle starts with expectedTitle
        //Both statement gets executed
    }

    @Test
    public void test4(){
        //verify if email contains @ sign
        String email = "mikesmith@gmail.com";
        Assert.assertTrue(email.contains("@"), "verify email contains @ sign");
        System.out.println("TEST4: PASS");

    }

    @Test
    public void test5(){
        //Assert.assertTrue(0>1, "verify 0 is greater than 1");
        Assert.assertFalse(0>1, "verify 0 is not greater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("test", "test");
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
