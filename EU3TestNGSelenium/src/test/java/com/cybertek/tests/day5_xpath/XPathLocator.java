package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPathLocator {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);
        WebElement button2 = driver.findElement(By.xpath("//*[@id='content']/div[1]/button[2]"));
        button2.click();

        System.out.println(driver.findElement(By.xpath("//p[@style='color:green']")).getText());
        System.out.println(driver.findElement(By.xpath("//p[text()='Clicked on button two!']")).getText());

        WebElement multipleText = driver.findElement(By.xpath("//h3"));
        System.out.println(multipleText.getText());

        driver.quit();
    }
}
