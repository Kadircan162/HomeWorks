package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test(priority = 2)
    public void onlyTwoWindows(){
        driver.get("http://practice.cybertekschool.com/windows");
        String firstWindowTitle = driver.getTitle();
        System.out.println("firstWindowTitle = " + firstWindowTitle);
        driver.findElement(By.linkText("Click Here")).click();
        String newWindowTitle = driver.getTitle();
        System.out.println("newWindowTitle = " + newWindowTitle);

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        String windowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();//Set is one of the interface that extends Collection interface
        //It's like List<> but differences are; it doesn't keep duplicates and also doesn't keep elements with order so that
        //we cannot find elements by index number.

        for (String handle : windowHandles) {
            if(!handle.equals(windowHandle)){
                driver.switchTo().window(handle);
            }
        }
        System.out.println("driver.getTitle() = New Window Title:" + driver.getTitle());

    }

    @Test (priority = 1)
    public void switchWindow() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();//first window
        driver.findElement(By.xpath("//a[.='Home']")).click();//second window
        driver.findElement(By.xpath("//a[.='Cybertek School']")).click();//third window
        Set<String> windows = driver.getWindowHandles();

        String switchToWindow = moreThanTwoWindows("New Window", windows);//calling switch method--returns the title of the switched window
        System.out.println("switchToWindow = " + switchToWindow);//getting title of the switched window

        Thread.sleep(2000);
        switchToWindow = moreThanTwoWindows("Cydeo", windows);//switch another window
        System.out.println("switchToWindow = " + switchToWindow);

    }

    public String moreThanTwoWindows(String switchWindow, Set<String> windows){

        //loop through each window in Set windows
        for(String eachWindow : windows){
            if(driver.getTitle().equals(switchWindow)){
                break;
            }
            driver.switchTo().window(eachWindow);
        }

        return driver.getTitle();

    }
}
