package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.SVGElementsPage;
import testBase.BaseClass;

public class SVGElementsTest extends BaseClass {

    @Test(groups = "Master")
    public void verifySVGElements() {
        SoftAssert softAssert = new SoftAssert();

        logger.info("verifySVGElements started.");
        SVGElementsPage se = new SVGElementsPage(driver);
        String header = se.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "SVG Elements" , "Mismatched.");

        se.svg();

        softAssert.assertAll();
        logger.info("verifySVGElements finished.");
    }
}
