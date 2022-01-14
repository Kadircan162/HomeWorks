package com.cybertek.tests.day10_actions_js_hover_jsexecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecuterDemo {
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
    public void clickWithJS(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        ChromeDriver chromeDriver = (ChromeDriver) driver;
        chromeDriver.executeScript("arguments[0].click();", dropdownLink);
    }

    @Test
    public void typeWithJS(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement disabledInbox = driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value=arguments[1]",disabledInbox,"hello");
    }

    @Test
    public void scrollUpAndDown() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,250)");//scroll down
        jse.executeScript("window.scrollBy(0,-250)");//scroll up

        driver.get("http://practice.cybertekschool.com/");
        WebElement element = driver.findElement(By.linkText("WYSIWYG Editor"));
        jse.executeScript("arguments[0].scrollIntoView();", element);

    }

    @Test //noNeed To ScrollDown To Interact With The Buttons Very Below TheHomepage
    public void interactButtonBelowTheScene() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.linkText("Help")).click();
        Thread.sleep(3000);
    }
}
