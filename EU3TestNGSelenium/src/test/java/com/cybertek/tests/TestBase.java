package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.IOException;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    //this class is used to create HTML report file
    protected ExtentHtmlReporter htmlReporter;
    //this class is used for starting nad building reports
    protected ExtentReports report;
    //this will  define a test, enables adding logs, authors, test steps
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //By initializing the html reporter, it creates a file with path which gets reports after executing test
        htmlReporter = new ExtentHtmlReporter(path);

        //set the title in report
        htmlReporter.config().setReportName(ConfigurationReader.getKeyValue("reportName"));

        //initialize ExtentReports class
        report = new ExtentReports();

        //attach the html report to report object to use the report info buried into ExtentHtmlReporter object
        report.attachReporter(htmlReporter);

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.getKeyValue("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
    }
    @BeforeMethod
    public void setUp(){
        driver = DriverSetup.getDriver();
        driver.get(ConfigurationReader.getKeyValue("loginpage_url"));
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }
    @AfterMethod
    public void burnDown(ITestResult result) throws InterruptedException, IOException {//ITest result describes the result of a test in TestNG
        //if test fails
        if(result.getStatus() == ITestResult.FAILURE){
            //record the name of failed TC and get the logs related to failed TC
            extentLogger.fail(result.getName());//fail method returns an ExtentTest object with failed TC info (name, logs, etc.)

            //take the screenshot and return location of it
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            //add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }
        Thread.sleep(1000);
        DriverSetup.closeDriver();
    }

    @AfterTest
    public void tearDownTest(){
        //this is when the report is actually created
        report.flush();
    }
}
