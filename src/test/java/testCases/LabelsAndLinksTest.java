package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.LabelsAndLinksPage;
import testBase.BaseClass;

public class LabelsAndLinksTest extends BaseClass {

    @Test(groups = "Master")
    public void verifyLabelsAndLinks() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        logger.info("verifyLabelsAndLinks started.");
        LabelsAndLinksPage ll = new LabelsAndLinksPage(driver);
        String header = ll.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Labels And Links", "Mismatched.");

        ll.mobiles();
        ll.laptops();
        ll.brokenLinks();

        softAssert.assertAll();
        logger.info("verifyLabelsAndLinks finished.");
    }
}
