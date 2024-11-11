package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.StaticWebTablePage;
import testBase.BaseClass;

public class StaticWebTableTest extends BaseClass  {

    @Test
    public void verifyStaticWebTable() {
        SoftAssert softAssert = new SoftAssert();

        StaticWebTablePage swt = new StaticWebTablePage(driver);
        String header = swt.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Static Web Table", "Mismatched.");

        swt.staticWebTable();

        softAssert.assertAll();
    }
}
