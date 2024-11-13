package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.StaticWebTablePage;
import testBase.BaseClass;

public class StaticWebTableTest extends BaseClass  {

    @Test(groups = "Master")
    public void verifyStaticWebTable() {
        SoftAssert softAssert = new SoftAssert();

        logger.info("verifyStaticWebTable started.");
        StaticWebTablePage swt = new StaticWebTablePage(driver);
        String header = swt.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Static Web Table", "Mismatched.");

        swt.staticWebTable();

        softAssert.assertAll();
        logger.info("verifyStaticWebTable finished.");
    }
}
