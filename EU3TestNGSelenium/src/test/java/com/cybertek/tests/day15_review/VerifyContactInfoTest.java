package com.cybertek.tests.day15_review;

import com.cybertek.pagesobjectmodels.ContactDetailsPage;
import com.cybertek.pagesobjectmodels.ContactsPage;
import com.cybertek.pagesobjectmodels.DashboardPage;
import com.cybertek.pagesobjectmodels.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInfoTest extends TestBase {
    /*
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers -> contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

    @Test
    public void contactDetailsTest(){
        extentLogger = report.createTest("Contact info verification test");

        LoginPage login = new LoginPage();

        String username = ConfigurationReader.getKeyValue("salesmanager_username");
        String password = ConfigurationReader.getKeyValue("salesmanager_password");

        extentLogger.info("enter username" + username);
        extentLogger.info("enter password" + password);
        extentLogger.info("Login as a sales manager");
        login.login(username, password);

        extentLogger.info("Navigate to customers -> contacts");
        new DashboardPage().navigateToModule("Customers", "Contacts");

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Click on email mbrackstone9@example.com");
        contactsPage.getContactEmailWebElement("mbrackstone9@example.com").click();

        ContactDetailsPage contactDetailsPage = new ContactDetailsPage();
        BrowserUtils.waitForVisibility(contactDetailsPage.getFullName(), 10);

        String actualFullName = contactDetailsPage.getFullName().getText();
        String expectedFullName = "Mariam Brackstone";

        extentLogger.info("Verify that full name is" + expectedFullName);
        Assert.assertEquals(actualFullName, expectedFullName, "Fullname are not correct");

        extentLogger.info("Verify that phone number is +18982323434");
        Assert.assertEquals(contactDetailsPage.getPhoneNumber().getText(), "+18982323434", "Phone number is not matching");

        extentLogger.info("Verify that email is mbrackstone9@example.com");
        Assert.assertEquals(contactDetailsPage.getEmail().getText(), "mbrackstone9@example.com", "Email is not matching");
        extentLogger.pass("PASSED");

    }

}
