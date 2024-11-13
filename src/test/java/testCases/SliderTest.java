package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.SliderPage;
import testBase.BaseClass;

public class SliderTest extends BaseClass {

    @Test(groups = "Master")
    public void verifySlider() {
        SoftAssert softAssert = new SoftAssert();

        logger.info("verifySlider started.");
        SliderPage s = new SliderPage(driver);
        String header = s.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Slider", "Mismatched.");
        s.slider();

        softAssert.assertAll();
        logger.info("verifySlider finished.");
    }
}
