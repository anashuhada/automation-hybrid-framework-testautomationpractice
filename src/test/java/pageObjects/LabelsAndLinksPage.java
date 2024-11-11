package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class LabelsAndLinksPage extends BasePage {

    public LabelsAndLinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Labels And Links']")
    WebElement textHeader;

    @FindBy(xpath = "//div[@id='mobiles']//h4")
    WebElement headerMobiles;

    @FindBy(xpath = "//div[@id='mobiles']//label")
    List<WebElement> listMobiles;

    @FindBy(xpath = "//div[@id='laptops']//h4")
    WebElement headerLaptops;

    @FindBy(xpath = "//div[@id='laptops']//a")
    List<WebElement> listLaptops;

    @FindBy(xpath = "//div[@id='broken-links']//h4")
    WebElement headerBrokenLinks;

    @FindBy(xpath = "//div[@id='broken-links']//a")
    List<WebElement> listBrokenLinks;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void mobiles() {
        String actualMobile = headerMobiles.getText();
        String expectedMobile = "Mobile Labels";
        Assert.assertEquals(actualMobile, expectedMobile, "Mismatched.");

        for(WebElement mobiles : listMobiles) {
            System.out.println("Mobile label is displayed: " + mobiles.isDisplayed());
        }
    }

    public void laptops() throws InterruptedException {
        String actualLaptop = headerLaptops.getText();
        String expectedLaptop = "Laptop Links";
        Assert.assertEquals(actualLaptop, expectedLaptop, "Mismatched.");

        // System.out.println("Total list of laptops: " + listLaptops.size());

        for (WebElement laptop : listLaptops) {
            String laptopName = laptop.getText();

            System.out.println(laptopName);

            if (laptopName.equals("Apple") || laptopName.equals("Lenovo") || laptopName.equals("Dell")) {
                laptop.click();
                Thread.sleep(1000);
                driver.navigate().back();
            }
        }
    }

    public void brokenLinks() throws InterruptedException {
        String actualBroken = headerBrokenLinks.getText();
        String expectedBroken = "Broken Links";
        Assert.assertEquals(actualBroken, expectedBroken, "Incorrect.");

        // System.out.println("Total broken links: " + listBrokenLinks.size());

        for(WebElement broken : listBrokenLinks) {
            wait.until(ExpectedConditions.visibilityOf(broken));
            wait.until(ExpectedConditions.elementToBeClickable(broken)).click();
            System.out.println("Broken url link: " + driver.getCurrentUrl());
            Thread.sleep(2000);
            driver.navigate().back();
        }
    }
}
