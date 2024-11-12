package testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.GUIElementsPage;
import testBase.BaseClass;

public class GUIElementsTest extends BaseClass  {

    @Test
    public void verifyGUIElements() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        GUIElementsPage gui = new GUIElementsPage(driver);

        String h1 = gui.getFirstHeading();
        // System.out.println(h1);
        if(h1.contains("Automation Testing Practice")) {
            softAssert.assertTrue(true);
        } else {
            softAssert.assertTrue(false);
        }

        String h2 = gui.getSecondHeading();
        // System.out.println(h2);
        softAssert.assertEquals(h2, "For Selenium, Cypress & Playwright", "Mismatched.");

        String name = randomName();
        gui.setTextName(name);
        System.out.println(name);

        String email = randomName() + "@example.com";
        gui.setTextEmail(email);
        System.out.println(email);

        String phone = randomNumeric();
        gui.setTextPhone(phone);
        System.out.println(phone);

        String address = randomAddress();
        gui.setTextAddress(address);
        System.out.println(address);

        gui.setGender();
        gui.setDays();
        gui.setSelectCountry();
        gui.unsortedList();
        gui.sortedList();
        gui.duplicateItems();
        gui.setDatePicker1("11", "March", "2024");
        gui.setDatePicker2("11", "Mar", "2025");

        softAssert.assertAll();
    }
}
