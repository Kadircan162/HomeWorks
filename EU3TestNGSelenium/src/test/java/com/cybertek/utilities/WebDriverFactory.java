package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*
A utility class is a class that is just a namespace for functions.
No instances of it can exist, and all its members are static. For example,
java.lang.Math and java.util.Collections are well known utility classes.
This annotation automatically turns the annotated class into one.
A utility class cannot be instantiated. By marking your class with @UtilityClass,
lombok will automatically generate a private constructor that throws an exception,
flags as error any explicit constructors you add, and marks the class final.
If the class is an inner class, the class is also marked static.
All members of a utility class are automatically marked as static. Even fields and inner classes.
 */
@UtilityClass
public class WebDriverFactory {

    WebDriver driver;
    public WebDriver getDriver(String browserType){

        if(browserType.toLowerCase().contains("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }else if(browserType.toLowerCase().contains("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }else if(browserType.toLowerCase().contains("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }
        driver.manage().window().maximize();
        return driver;
    }

}
