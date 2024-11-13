package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HiddenElementsAndAJAXPage;
import testBase.BaseClass;

public class HiddenElementsAndAJAXTest extends BaseClass {

    @Test(groups = "Master")
    public void verifyHiddenElementsAndAJAX() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        logger.info("verifyHiddenElementsAndAJAX started.");
        HiddenElementsAndAJAXPage hea = new HiddenElementsAndAJAXPage(driver);
        String header = hea.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Hidden Elements & AJAX", "Incorrect.");

        hea.setInput("Java", "Python");
        hea.setCheckbox();
        hea.setLoadAJAX();

        softAssert.assertAll();
        logger.info("verifyHiddenElementsAndAJAX finished.");
    }
}
