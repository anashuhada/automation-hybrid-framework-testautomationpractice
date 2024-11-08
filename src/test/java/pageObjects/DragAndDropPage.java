package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Drag and Drop']")
    WebElement textHeader;

    @FindBy(xpath = "//div[@id='draggable']")
    WebElement source;

    @FindBy(xpath = "//div[@id='droppable']")
    WebElement target;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void dragAndDrop() {
        act.dragAndDrop(source, target).perform();
    }
}
