package com.cybertek.tests.Homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckBox {

/*Test Case Verify CheckBox CheckAll and UncheckAll Buttons

1. Go to
    http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2. Login with-----Username: Tester, password: test
3. Click on check all button verify all the checkboxes are checked
4. Click on uncheck all button verify that all the checkboxes are unchecked
5. Select one of the checkbox and delete one person
6. Then verify that deleted item is no longer exists
}

 */

    List<WebElement> checkBoxes;
    WebDriver driver;
    String checkBoxId;
    int idSeq;

    @BeforeTest
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button']")).click();
    }

    @Test
    public void allCheckBoxesChecked() throws InterruptedException {

        checkBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        driver.findElement(By.xpath("//a[.='Check All']")).click();
        getIdSeq();
        for(int i=idSeq; i<idSeq+checkBoxes.size(); i++){
            Assert.assertTrue(driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl0" + i + "_OrderSelector")).isSelected(), "All checkboxes are not selected");
        }
    }

    @Test
    public void allCheckBoxesUnchecked() throws InterruptedException {
        allCheckBoxesChecked();
        driver.findElement(By.xpath("//a[.='Uncheck All']")).click();
        getIdSeq();
        for(int i=idSeq; i<idSeq+checkBoxes.size(); i++){
            Assert.assertFalse(driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl0" + i + "_OrderSelector")).isSelected(),"All checkboxes are not Unselected");
        }
    }

    @Test
    public void removePerson() throws InterruptedException {
        allCheckBoxesUnchecked();
        deletePerson("Bob Feather");
    }

    public void deletePerson(String removePerson) {

        String removedPersonCardNumber = driver.findElement(By.xpath("//tbody//td[.='"+removePerson+"']/following-sibling::td[9]")).getText();

        driver.findElement(By.xpath("//td[.='" + removePerson + "']/preceding-sibling::td/input")).click();
        driver.findElement(By.cssSelector("[value='Delete Selected']")).click();

        checkBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        for(int i=idSeq; i<idSeq+checkBoxes.size(); i++){
           String searchCardNumbers = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl0" + i + "_OrderSelector']/parent::*/following-sibling::td[10]")).getText();
           System.out.println("searchCardNumbers = " + searchCardNumbers);
           Assert.assertNotEquals(removedPersonCardNumber, searchCardNumbers, "Fail: Person still exist");
        }

    }

    public void getIdSeq(){
        String checkBoxId = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).toString();
        System.out.println(checkBoxId);
        String[] checkBoxIdTextArray = checkBoxId.split(" ");
        System.out.println("Arrays.toString(checkBoxIdTextArray) = " + Arrays.toString(checkBoxIdTextArray));
        String idCtl = checkBoxIdTextArray[7].substring(28,33);
        if(idCtl.startsWith("ctl")){
            idSeq = Integer.parseInt(idCtl.substring(4,5));
        }else {
            System.out.println("id sequence could not found");
            return;
        }

    }

}
