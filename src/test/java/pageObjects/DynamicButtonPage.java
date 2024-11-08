package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicButtonPage extends BasePage {

    public DynamicButtonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Dynamic Button']")
    WebElement textHeader;

    @FindBy(xpath = "//button[normalize-space()='START']")
    WebElement buttonStart;

    public boolean getTextHeader() {
        try {
            return textHeader.isDisplayed();
        } catch(Exception e) {
            e.getMessage();
            return false;
        }
    }

    public void clickButtonStart() {
        wait.until(ExpectedConditions.visibilityOf(buttonStart));
        System.out.println("START state");
        wait.until(ExpectedConditions.elementToBeClickable(buttonStart)).click();
        System.out.println("STOP state");
    }
}
