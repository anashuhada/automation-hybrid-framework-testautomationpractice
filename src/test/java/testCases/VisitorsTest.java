package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.VisitorsPage;
import testBase.BaseClass;

public class VisitorsTest extends BaseClass {

    @Test
    public void verifyVisitors() {
        SoftAssert softAssert = new SoftAssert();

        VisitorsPage v = new VisitorsPage(driver);
        String header = v.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Visitors", "Mismatched.");

        v.getTotalCount();

        softAssert.assertAll();
    }
}
