package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisitorsPage extends BasePage {

    public VisitorsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Visitors']")
    WebElement textHeader;

    @FindBy(xpath = "//span[@id='Stats1_totalCount']")
    WebElement totalCount;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void getTotalCount() {
        System.out.println(totalCount.isDisplayed());
        System.out.println(totalCount.getText());
    }
}
