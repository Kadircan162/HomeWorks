package com.cybertek.tests.Homeworks.VytrackHW;

import com.cybertek.pagesobjectmodels.CalendarEventsPage;
import com.cybertek.pagesobjectmodels.DashboardPage;
import com.cybertek.pagesobjectmodels.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VytrackHWCalenderEventTest extends TestBase {

    @Test
    public void testCase1(){
        extentLogger = report.createTest("Vytrack Calender Event Test");
        extentLogger.info("Go to “https://qa1.vytrack.com/");
        extentLogger.info("Login as a store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();
        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        extentLogger.info("Verify that page subtitle 'Options' is displayed");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertTrue(calendarEventsPage.optionsSubtitle.isDisplayed(), "Options subtitle is not displayed");
        extentLogger.info("PASS");
    }

    @Test
    public void testCase2(){
        extentLogger = report.createTest("Vytrack Calender Event Test");
        extentLogger.info("Go to “https://qa1.vytrack.com/");
        extentLogger.info("Login as a store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        String actualPageNumber = calendarEventsPage.pageNumber.getAttribute("value");
        String expectedPageNumber = "1";
        extentLogger.info("Verify that page number equals to '1'");
        Assert.assertEquals(actualPageNumber, expectedPageNumber, "Page number is not " + expectedPageNumber);
        extentLogger.info("PASS");
    }

    @Test
    public void testCase3(){
        extentLogger = report.createTest("Vytrack Calender Event Test");
        extentLogger.info("Go to “https://qa1.vytrack.com/");
        extentLogger.info("Login as a store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        String actualPerPageNumber = calendarEventsPage.perPageNumber.getText().trim();
        String expectedPerPageNumber = "25";
        extentLogger.info("Verify that view per page number equals to '25'");
        Assert.assertEquals(actualPerPageNumber, expectedPerPageNumber, "Per page number is not " + expectedPerPageNumber);
        extentLogger.info("PASS");
    }

    @Test
    public void testCase4() throws InterruptedException {
        extentLogger = report.createTest("Vytrack Calender Event Test");
        extentLogger.info("Go to “https://qa1.vytrack.com/");
        extentLogger.info("Login as a store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        wait.until(ExpectedConditions.visibilityOf(calendarEventsPage.nextPageArrow));
        List<WebElement> rowList = new ArrayList<>(calendarEventsPage.eventList);//takes the rows at the first page
        int pageSetNumber = Integer.parseInt(calendarEventsPage.numberOfPageSetText.getText().trim().split(" ")[1]);

        for(int i=1; i<pageSetNumber; i++){//click the next page set until the right arrow btn disabled
            wait.until(ExpectedConditions.visibilityOf(calendarEventsPage.numberOfPageSetText));
            calendarEventsPage.nextPageArrow.click();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
            Thread.sleep(2000);
            rowList.addAll(calendarEventsPage.eventList);//adds the rows from the next page
        }
        int recordNumber = Integer.parseInt(calendarEventsPage.recordNumber.getText().split(" ")[2]);
        extentLogger.info("Verify that number of calendar events (rows in the table) equals to number of records");
        System.out.println("rowList.size() = " + rowList.size());
        System.out.println("recordNumber = " + recordNumber);
        Assert.assertEquals(recordNumber, rowList.size(), "Record number and events quantity are not matching");
        extentLogger.info("PASS");
    }

    @Test
    public void testCase5() throws InterruptedException {
        extentLogger = report.createTest("Vytrack Calender Event Test");
        extentLogger.info("Go to “https://qa1.vytrack.com/");
        extentLogger.info("Login as a store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        extentLogger.info("Click on the top checkbox to select all");
        calendarEventsPage.checkAllBtn.click();
        extentLogger.info("Verify that all calendar events were selected");

        for(WebElement each : calendarEventsPage.eventList){//checking first page
            Assert.assertTrue(each.isSelected(), "Not all check boxes are checked");
        }

        int pageSetNumber = Integer.parseInt(calendarEventsPage.numberOfPageSetText.getText().trim().split(" ")[1]);
        for(int i=1; i<pageSetNumber; i++){//click the next page set until the right arrow btn disabled
            wait.until(ExpectedConditions.visibilityOf(calendarEventsPage.numberOfPageSetText));
            calendarEventsPage.nextPageArrow.click();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
            for(WebElement each : calendarEventsPage.eventList){//checking second page
                Assert.assertTrue(each.isSelected(), "Not all check boxes are checked");
            }
        }
        extentLogger.info("PASS");
    }

    @Test
    public void testCase6(){
        extentLogger = report.createTest("Vytrack Calender Event Test");
        extentLogger.info("Go to “https://qa1.vytrack.com/");
        extentLogger.info("Login as a store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Select 'Testers meeting'");

        int pageSetNumber = Integer.parseInt(calendarEventsPage.numberOfPageSetText.getText().trim().split(" ")[1]);
        for(int i=1; i<pageSetNumber; i++){//click the next page set until the right arrow btn disabled
            for (WebElement eachTitle : calendarEventsPage.titleList) {
                if(eachTitle.getText().trim().contains("Testers meeting")){
                    eachTitle.click();
                    break;
                }
            }
            wait.until(ExpectedConditions.visibilityOf(calendarEventsPage.numberOfPageSetText));
            calendarEventsPage.nextPageArrow.click();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
        }

        wait.until(ExpectedConditions.visibilityOf(calendarEventsPage.keyList.get(0)));
        Map<String, String> capitalCities = calendarEventsPage.getLabelDescriptionTable();

        extentLogger.info("Verify Title -> Testers meeting");
        Assert.assertEquals(capitalCities.get("Title"), "Testers meeting", "'Testers meeting' is not displayed");

        extentLogger.info("Verify Description -> This is a a weekly testers meeting");
        Assert.assertEquals(capitalCities.get("Description"), "This is a a weekly testers meeting", "'This is a a weekly testers meeting' is not displayed");

        extentLogger.info("Verify Start -> Nov 27, 2019, 9:30 AM");
        Assert.assertEquals(capitalCities.get("Start"), "Nov 27, 2019, 9:30 AM", "'Nov 27, 2019, 9:30 AM' is not displayed");

        extentLogger.info("Verify End -> Nov 27, 2019, 10:30 AM");
        Assert.assertEquals(capitalCities.get("End"), "Nov 27, 2019, 10:30 AM", "'Nov 27, 2019, 10:30 AM' is not displayed");

        extentLogger.info("Verify All-Day Event -> No");
        Assert.assertEquals(capitalCities.get("All-Day Event"), "No", "'No' is not displayed");

        extentLogger.info("Verify Organizer -> John Doe");
        Assert.assertEquals(capitalCities.get("Organizer"), "John Doe", "'John Doe' is not displayed");

        extentLogger.info("Verify Call Via Hangout -> No");
        Assert.assertEquals(capitalCities.get("Call Via Hangout"), "No", "'No' is not displayed");

        extentLogger.info("PASS");

    }

}
