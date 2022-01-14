package com.cybertek.tests.webTablesExample;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void burnDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void printTableTest(){
        WebElement tableElement = driver.findElement(By.cssSelector("#table1[id='table1']"));
        System.out.println("tableElement.getText() = " + tableElement.getText());//we get the text of a table as a whole string
    }

    @Test
    public void getAllHeaders(){
        //first way to find column numbers
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("columns.size() = " + columns.size());
        for (WebElement column : columns) {

            System.out.println("column.getText() = " + column.getText());
        }

        //second way to find column numbers
        int numberOfColumns=0;
        for (int i = 1; i <= 6; i++) {
             driver.findElement(By.xpath("//table[@id='table1']//th["+i+"]"));
             numberOfColumns = i;
        }
        System.out.println("numberOfColumns = " + numberOfColumns);

    }

    @Test
    public void printTableSize(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("rows.size() = " + rows.size());
        int countRow=0;
        for (int i = 1; i <= 4; i++) {//number of rows w/o header row
            driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            countRow = i;
        }
        System.out.println("countRow = " + countRow);
    }

    @Test
    public void printRow(){
        System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]")).getText());//second row
        for (int i = 1; i <= 4; i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println("row = " + row.getText());
        }

    }

    @Test
    public void printCell(){
        //write each cell with List
        List<WebElement> columnNumber = driver.findElements(By.xpath("//table[@id='table1']//th"));
        List<WebElement> rowNumber = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));

        System.out.println("cellList.size() = " + columnNumber.size());
        //Writing header
        for (WebElement cellEach : columnNumber) {
            System.out.print(cellEach.getText()+"\t");
        }
        System.out.println();

        //write each cell dynamically
        for (int i = 1; i <= rowNumber.size(); i++) {
            for (int j = 1; j <= columnNumber.size(); j++) {
                String cellLocator = "//table[@id='table1']//tbody/tr["+i+"]/td["+j+"]";
                WebElement cellElement = driver.findElement(By.xpath(cellLocator));
                System.out.print(cellElement.getText()+"\t");
            }
            System.out.println();
        }

    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow() throws InterruptedException {
        driver.findElement(By.xpath("//table[@id='table1']//span[.='First Name']")).click();//sorting table rows for each click
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@id='table1']//span[.='First Name']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@id='table1']//span[.='First Name']")).click();
        Thread.sleep(2000);

        String expectedName = "John";
        String actualName = driver.findElement(By.xpath("//table[@id='table1']//td[.='"+expectedName+"']")).getText();
        System.out.println("actualName = " + actualName);
        Assert.assertEquals(expectedName, actualName);

        String email = driver.findElement(By.xpath("//table[@id='table1']//td[.='"+expectedName+"']/following-sibling::td[1]")).getText();
        System.out.println("email = " + email);
    }
}
