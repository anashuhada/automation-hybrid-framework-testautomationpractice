package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HoverMousePage;
import testBase.BaseClass;

public class HoverMouseTest extends BaseClass {

    @Test
    public void verifyHoverMouse() {
        SoftAssert softAssert = new SoftAssert();

        HoverMousePage hm = new HoverMousePage(driver);
        String header = hm.getTextHeader();
        // System.out.println(header);
        if(header.contains("Mouse")) {
            softAssert.assertTrue(true);
        } else {
            softAssert.assertTrue(false);
        }

        String paragraph = hm.getTextParagraph();
        // System.out.println(paragraph);
        if(paragraph.contains("Move")) {
            softAssert.assertTrue(true);
        } else {
            softAssert.assertTrue(false);
        }

        hm.hoverMouse();

        softAssert.assertAll();
    }
}
