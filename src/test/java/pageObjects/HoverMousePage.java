package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HoverMousePage extends BasePage {

    public HoverMousePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='HTML3']//h2")
    WebElement textHeader;

    @FindBy(xpath = "//div[@id='HTML3']//p")
    WebElement textParagraph;

    @FindBy(xpath = "//button[@class='dropbtn']")
    WebElement buttonPointMe;

    @FindBy(xpath = "//div[@class='dropdown-content']//a[contains(text(),'Mobiles')]")
    WebElement hoverMobiles;

    @FindBy(xpath = "//div[@class='dropdown-content']//a[contains(text(),'Laptops')]")
    WebElement hoverLaptops;


    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public String getTextParagraph() {
        try {
            return textParagraph.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void hoverMouse() {
        act.moveToElement(buttonPointMe)
                .pause(2000)
                .moveToElement(hoverMobiles)
                .pause(2000)
                .moveToElement(hoverLaptops)
                .perform();
    }
}
