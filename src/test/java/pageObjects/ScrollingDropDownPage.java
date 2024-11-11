package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ScrollingDropDownPage extends BasePage {

    public ScrollingDropDownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Scrolling DropDown']")
    WebElement textHeader;

    @FindBy(xpath = "//input[@id='comboBox']")
    WebElement inputBox;

    @FindBy(xpath = "//div[@id='dropdown']//div[@class='option']")
    List<WebElement> listOption;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void scrollingDropDown() {
        inputBox.click();
        for(WebElement option : listOption) {
            // System.out.println(option.getText()); // Item 100
            if(option.getText().equals("Item 100")) {
                act.moveToElement(option)
                        .pause(2000)
                        .click()
                        .perform();
                System.out.println("Scrolling down until Item 100 found");
                break;
            }
        }
    }
}
