package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.ScrollingDropDownPage;
import testBase.BaseClass;

public class ScrollingDropDownTest extends BaseClass {

    @Test(groups = "Master")
    public void verifyScrollingDropDown() {
        SoftAssert softAssert = new SoftAssert();

        logger.info("verifyScrollingDropDown started.");
        ScrollingDropDownPage sd = new ScrollingDropDownPage(driver);
        String header = sd.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Scrolling DropDown", "Mismatched.");

        sd.scrollingDropDown();

        softAssert.assertAll();
        logger.info("verifyScrollingDropDown finished.");
    }
}
