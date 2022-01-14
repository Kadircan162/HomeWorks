package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Set;

public class iFrameTest {

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

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/iframe");//iframe divide a webpage so that we can have different htmls,
        //different source code in html code (e.g. it's possible by iframe for a webpage to have videos belongs to other webpages).

        driver.switchTo().frame("mce_0_ifr");//first way to switch baby html embedded in frame.
        WebElement webElement = driver.findElement(By.id("tinymce"));
        webElement.clear();
        Thread.sleep(2000);
        webElement.sendKeys("Mike Smith");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();//Once we switch to baby html we need to switch back to the biggest one to interact there.
        //Now it switches back all the way up to the biggest html.

        driver.switchTo().frame(0);//second way to switch frame (to baby html) with index number -- we don't count main html as for index since it is not an element
        //so the first baby inner html has 0 index
        webElement.clear();
        webElement.sendKeys("Mike Smith with index number of html");

        driver.switchTo().parentFrame();//second way of switching back to parent html (here since there are just one parent html, it works,
        //but normally with this way we can go only one level up to html.

        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));//third way of switching to baby html with element
        Thread.sleep(1000);
        webElement.sendKeys("Switch with webElement");
        Thread.sleep(1000);

        driver.switchTo().defaultContent();

    }

    @Test
    public void nestedFramesTest2(){

        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.xpath("//body[contains(text(), 'RIGHT')]")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.xpath("//body[contains(text(), 'LEFT')]")).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText());
    }
}

