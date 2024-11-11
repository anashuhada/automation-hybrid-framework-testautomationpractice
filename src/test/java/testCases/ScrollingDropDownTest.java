package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.ScrollingDropDownPage;
import testBase.BaseClass;

public class ScrollingDropDownTest extends BaseClass {

    @Test
    public void verifyScrollingDropDown() {
        SoftAssert softAssert = new SoftAssert();

        ScrollingDropDownPage sd = new ScrollingDropDownPage(driver);
        String header = sd.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Scrolling DropDown", "Mismatched.");

        sd.scrollingDropDown();

        softAssert.assertAll();
    }
}
