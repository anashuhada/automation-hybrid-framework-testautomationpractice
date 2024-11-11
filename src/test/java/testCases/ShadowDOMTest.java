package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.ShadowDOMPage;
import testBase.BaseClass;

public class ShadowDOMTest extends BaseClass {

    @Test
    public void verifyShadowDOM() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        ShadowDOMPage sdom = new ShadowDOMPage(driver);

        String header = sdom.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "ShadowDOM", "Incorrect");

        sdom.shadowMobiles();
        sdom.shadowLaptops();
        sdom.shadowBlog();
        sdom.shadowInputBox("Selenium");
        sdom.shadowCheckbox();
        sdom.shadowUploadFile("/Volumes/KINGSTON/Software Testing/Automation Testing/txt_file1");

        softAssert.assertAll();
    }
}
