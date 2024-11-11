package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.SliderPage;
import testBase.BaseClass;

public class SliderTest extends BaseClass {

    @Test
    public void verifySlider() {
        SoftAssert softAssert = new SoftAssert();

        SliderPage s = new SliderPage(driver);
        String header = s.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Slider", "Mismatched.");
        s.slider();

        softAssert.assertAll();
    }
}
