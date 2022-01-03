package com.cybertek.tests.homeworks.EU7_CheckBox_HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
/*
Test Case Verify CheckBox CheckAll and UncheckAll Buttons
1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2.    Login with-----Username: Tester, password: test
       // Test Case 1
3.    Click on check all button verify all the checkboxes are checked
4.    Click on uncheck all button verify that all the checkboxes are unchecked
       // Test Case 2
5.    Select one of the checkbox and delete one person
6.    Then verify that deleted item is no longer exists

    What is the precondition for both Test Cases? Login to webPage
    Can I out the same precondition to BeforeMethod? Yes
 */
public class NewCheckBox_HW_LastVersion {

    public WebDriver driver;

    @BeforeMethod
    public void openPage() {
        driver = WebDriverFactory.getDriver("chrome"); // initialize our driver object
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.manage().window().maximize();
        // Login to WebPage
        WebElement userNameBox = driver.findElement(By.id("ctl00_MainContent_username"));
        userNameBox.sendKeys("Tester");
        WebElement passwordBox = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$password']"));
        passwordBox.sendKeys("test");
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

    @Test (priority = 1)
    public void checkAndUncheckBoxAll() {
        // 1-Click on check all button
        WebElement checkAllButton = driver.findElement(By.linkText("Check All"));
        checkAllButton.click();

        // 2-verify all the checkboxes are checked by using findElements()
        List<WebElement> list = driver.findElements(By.cssSelector("[type='checkbox']"));

        for(WebElement each : list) {
            Assert.assertTrue(each.isSelected(), "The CheckBox IS NOT selected");
        }

        // verify all the checkboxes are checked without using findElements()
/*
        for (int i = 1; i <= 8 ; i++) {
            String rowChechBoxLocator = "(//input[@type='checkbox'])["+i+"]"; // String Concatenation
            WebElement rowCheckBox = driver.findElement(By.xpath(rowChechBoxLocator));
            Assert.assertTrue(rowCheckBox.isSelected(),"The CheckBox IS NOT selected");
        }
*/
        // 3-Click on uncheck all button
        WebElement unheckAllButton = driver.findElement(By.linkText("Uncheck All"));
        unheckAllButton.click();

        // 4-verify all the checkboxes are not selected by using findElements()
        List<WebElement> list2 = driver.findElements(By.cssSelector("[type='checkbox']"));

        for(WebElement each : list2) {
            Assert.assertFalse(each.isSelected(),"The CheckBox IS STILL selected");
        }

        // verify all the checkboxes are not checked without using findElements()
/*
        for (int i = 1; i <= 8 ; i++) {
            String rowChechBoxLocator = "(//input[@type='checkbox'])["+i+"]"; // String Concatination
            WebElement rowCheckBox = driver.findElement(By.xpath(rowChechBoxLocator));
            // Assert False method  rowCheckBox.isSelected() = NO looking for a FALSE result
            Assert.assertFalse(rowCheckBox.isSelected(),"The CheckBox IS STILL selected");
        }
 */

    }

    @Test (priority = 2)
    public void deleteAnyPerson() throws InterruptedException {
        //click on the check box where the name is Clare Jefferson
/*        String name = "Clare Jefferson";
        String locatorCheckBoxOfPerson = "//*[contains(text(),'" + name + "')]/..//input";

        WebElement checkBoxOfPerson = driver.findElement(By.xpath(locatorCheckBoxOfPerson));

 */
        selectPerson("Clare Jefferson").click();
        Thread.sleep(1000);

        //click on the delete button
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();
        Thread.sleep(1000);

        //For Assertion
        //Put all the web elements for names in a list
        String eachNameLocator = "//input[@type='checkbox']/../../td[2]";
        List<WebElement> allNames1 = driver.findElements(By.xpath(eachNameLocator));

        //Create an empty arraylist to get text of web elements inside allNames1
        ArrayList<String> allNames2 = new ArrayList<>();

        //get text of each element from allNames1 and put them to allNames2
        for (WebElement webElement : allNames1) {
            allNames2.add(webElement.getText());
        }

        //Do the verification
        Assert.assertFalse(allNames2.contains("Clare Jefferson"));

    }

    // returns any Checkbox web element based on the given person name
    public WebElement selectPerson(String name){

        String locatorCheckBoxOfPerson = "//*[contains(text(),'" + name + "')]/..//input";

        return driver.findElement(By.xpath(locatorCheckBoxOfPerson));
    }

}
