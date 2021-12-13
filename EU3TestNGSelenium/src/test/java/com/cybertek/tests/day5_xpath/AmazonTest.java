package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    /*Task:
     - Go to amazon.com
     - search for selenium
     - click search button
     - verify 1-48 of 384 results for selenium
     */
    public static void main(String[] args) {

        getSearchResult("chrome", "selenium");
//        getSearchResult("firefox", "selenium");
//
//        getSearchResult("firefox", "java");
//        getSearchResult("edge", "java");

    }

    public static void getSearchResult(String browser, String search) {

        WebDriver driver = WebDriverFactory.getDriver(browser);
        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys(search);

        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        //WebElement searchResult = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]"));
        WebElement searchResult = driver.findElement(By.xpath("//span[contains(text(), 'results for')]"));
        WebElement searchedItem = driver.findElement(By.xpath("//span [@class='a-color-state a-text-bold'][@dir='auto']"));

        String expectedResult = "1-48 of 192 results for \"selenium\"";
        String actualResult = searchResult.getText() + " " + searchedItem.getText();

            if(expectedResult.equals(actualResult)){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
                System.out.println("actualResult = " + actualResult);
                System.out.println("expectedResult = " + expectedResult);
            }

        driver.quit();

    }

}
