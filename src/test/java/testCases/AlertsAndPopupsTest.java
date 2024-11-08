package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.AlertsAndPopupsPage;
import testBase.BaseClass;

public class AlertsAndPopupsTest extends BaseClass {

    @Test
    public void verifyAlertsAndPopups() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        AlertsAndPopupsPage ap = new AlertsAndPopupsPage(driver);
        String header = ap.getTextHeader();
        // System.out.println(header);
        if(header.equals("Alerts & Popups")) {
            softAssert.assertTrue(true);
        } else {
            softAssert.assertTrue(false);
        }

        ap.simpleAlert();
        ap.confirmAlert();
        ap.promptAlert("Ana");
        ap.newTab();
        ap.newWindow();

        softAssert.assertAll();
    }
}
