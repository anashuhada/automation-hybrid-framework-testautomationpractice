package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.DynamicButtonPage;
import testBase.BaseClass;

public class DynamicButtonTest extends BaseClass {

    @Test(groups = "Master")
    public void verifyDynamicButton() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        logger.info("verifyDynamicButton started.");
        DynamicButtonPage db = new DynamicButtonPage(driver);
        boolean header = db.getTextHeader();
        // System.out.println(header);
        if(header == true) {
            softAssert.assertTrue(true);
        } else {
            softAssert.assertTrue(false);
        }

        db.clickButtonStart();

        softAssert.assertAll();
        logger.info("verifyDynamicButton finished.");
    }
}
