package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.VisitorsPage;
import testBase.BaseClass;

public class VisitorsTest extends BaseClass {

    @Test(groups = "Master")
    public void verifyVisitors() {
        SoftAssert softAssert = new SoftAssert();

        logger.info("verifyVisitors finished.");
        VisitorsPage v = new VisitorsPage(driver);
        String header = v.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Visitors", "Mismatched.");

        v.getTotalCount(); // 2,506,583 (13/11/2024)

        softAssert.assertAll();
        logger.info("verifyVisitors finished.");
    }
}
