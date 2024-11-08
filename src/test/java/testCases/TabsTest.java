package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.TabsPage;
import testBase.BaseClass;

public class TabsTest extends BaseClass {

    @Test
    public void verifyTabs() {
        SoftAssert softAssert = new SoftAssert();

        TabsPage t = new TabsPage(driver);
        String header = t.getTextHeader();
        System.out.println(header);
        softAssert.assertEquals(header, "Tabs", "Incorrect.");

        boolean logo = t.getLogoStatus();
        if(logo == true) {
            softAssert.assertTrue(true);
        } else {
            softAssert.assertTrue(false);
        }

        t.setTextInputBox("Selenium");

        softAssert.assertAll();
    }
}
