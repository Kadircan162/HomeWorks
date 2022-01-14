package com.cybertek.tests.Homeworks.oscarsTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
Task3:
          1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
          2. Login with username: Tester, password: test
          3. Click  Order button
          4. Verify under Product Information, selected option is “MyMoney”
          5. Then select FamilyAlbum, make quantity 2, and click Calculate,
          6. Then verify Total is equal to Quantity*PricePerUnit

 */

public class Task3_InteractWithForm {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void calculate() throws InterruptedException {

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.xpath("//a[text()='Order']")).click();

        Select select = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        WebElement option = select.getFirstSelectedOption();
        Assert.assertEquals(option.getText(), "MyMoney", "MyMoney option is not selected");
        select.selectByVisibleText("FamilyAlbum");

        WebElement quantityField = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityField.sendKeys(Keys.chord(Keys.CONTROL, "a"), "2");

        driver.findElement(By.cssSelector("[value='Calculate']")).click();

        int quantity = Integer.parseInt(quantityField.getAttribute("value"));

        WebElement pricePerCountField = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));
        int pricePerCount = Integer.parseInt(pricePerCountField.getAttribute("value"));

        WebElement total = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));
        int actualTotal = Integer.parseInt(total.getAttribute("value"));
        int expectedTotal = quantity*pricePerCount;//Quantity*PricePerUnit

        Assert.assertEquals(actualTotal, expectedTotal, "Total is NOT equal to Quantity*PricePerUnit");

    }

    @AfterTest
    public void burnDown() {
        driver.quit();
    }


}
