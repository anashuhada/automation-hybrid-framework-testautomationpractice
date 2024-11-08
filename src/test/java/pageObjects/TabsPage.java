package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TabsPage extends BasePage {

    public TabsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Tabs']")
    WebElement textHeader;

    @FindBy(xpath = "//img[@class='wikipedia-icon']")
    WebElement logoStatus;

    @FindBy(xpath = "//input[@id='Wikipedia1_wikipedia-search-input']")
    WebElement textInputBox;

    @FindBy(xpath = "//div[@id='wikipedia-search-result-link']//a")
    List<WebElement> searchResult;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public boolean getLogoStatus() {
        try {
            return logoStatus.isDisplayed();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void setTextInputBox(String text) {
        textInputBox.clear();
        textInputBox.sendKeys(text);
        textInputBox.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfAllElements(searchResult));
        // System.out.println("Number of search results found: " + searchResult.size());

        for(WebElement search : searchResult) {
            // System.out.println(search.getText()); // Selenium (software)
            if(search.getText().equals("Selenium (software)")) {
                search.click();
                System.out.println("Click on Selenium (software)");
                break;
            }
        }
    }
}
