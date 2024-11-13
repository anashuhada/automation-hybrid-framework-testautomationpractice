package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.DoubleClickPage;
import testBase.BaseClass;

public class DoubleClickTest extends BaseClass {

    @Test(groups = "Master")
    public void verifyDoubleClick() {
        SoftAssert softAssert = new SoftAssert();

        logger.info("verifyDoubleClick started.");
        DoubleClickPage dc = new DoubleClickPage(driver);
        String header = dc.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Double Click", "Incorrect.");

        dc.clickButtonCopyText("Automation Hybrid Framework");

        softAssert.assertAll();
        logger.info("verifyDoubleClick finished.");
    }
}
