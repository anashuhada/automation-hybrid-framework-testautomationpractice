package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoubleClickPage extends BasePage {

    public DoubleClickPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Double Click']")
    WebElement textHeader;

    @FindBy(xpath = "//input[@id='field1']")
    WebElement inputBox1;

    @FindBy(xpath = "//input[@id='field2']")
    WebElement inputBox2;

    @FindBy(xpath = "//button[normalize-space()='Copy Text']")
    WebElement buttonCopyText;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void clickButtonCopyText(String text) {
        inputBox1.clear();
        inputBox1.sendKeys(text);

        act.doubleClick(buttonCopyText).perform();

        String textInput = inputBox2.getAttribute("value");
        System.out.println(textInput);

        if(textInput.equals(text)) {
            System.out.println("Text copied.");
        } else {
            System.out.println("Text not copied correctly.");
        }
    }
}
