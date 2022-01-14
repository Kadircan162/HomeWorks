package com.cybertek.tests.day10_actions_js_hover_jsexecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void burnDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void hoverMouse(){
        driver.get("http://practice.cybertekschool.com/hovers");
        Actions actions = new Actions(driver);

        List<WebElement> imgList = driver.findElements(By.cssSelector("[class*=figure]"));

        for (int i = 0; i < imgList.size(); i++) {
            actions.moveToElement(imgList.get(i)).perform();
            Assert.assertTrue(imgList.get(i).isDisplayed(), "Image not displayed");
        }

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        //To accept cookies -->
        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        Thread.sleep(2000);

        //if you see accept and close message use this -->
        //driver.findElement(By.xpath("//*[.='Accept and Close']")).click();

        actions.dragAndDrop(source, target).perform();
    }

    @Test
    public void mouseMoveDragDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        Thread.sleep(2000);

        //actions.moveToElement(source).clickAndHold().moveToElement(target).release().perform();
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

    }



}
