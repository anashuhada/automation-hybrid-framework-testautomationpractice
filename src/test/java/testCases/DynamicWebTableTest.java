package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.DynamicWebTablePage;
import testBase.BaseClass;

public class DynamicWebTableTest extends BaseClass {

    @Test
    public void verifyDynamicWebTable() {
        SoftAssert softAssert = new SoftAssert();

        DynamicWebTablePage dwt = new DynamicWebTablePage(driver);

        String header = dwt.getTextHeader();
        System.out.println(header);
        if(header.equals("Dynamic Web Table")) {
            softAssert.assertTrue(true);
        } else {
            softAssert.assertTrue(false);
        }

        dwt.getChromeCPU();
        dwt.getFirefoxMemory();
        dwt.getChromeNetwork();
        dwt.getFirefoxDisk();

        softAssert.assertAll();
    }
}
