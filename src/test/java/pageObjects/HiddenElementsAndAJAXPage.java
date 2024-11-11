package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HiddenElementsAndAJAXPage extends BasePage {

    public HiddenElementsAndAJAXPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Hidden Elements & AJAX']")
    WebElement linkHiddenAJAX;

    @FindBy(xpath = "//h3[normalize-space()='Hidden Elements & AJAX']")
    WebElement textHeader;

    @FindBy(xpath = "//div[@id='container']//input[@type='text' and @id='input1']")
    WebElement inputBox1;

    @FindBy(xpath = "//div[@id='container']//input[@type='text' and @id='input2']")
    WebElement inputBox2;

    @FindBy(xpath = "//button[@id='toggleInput']")
    WebElement buttonToggleInput;

    @FindBy(xpath = "//input[@id='checkbox1' and @id='checkbox1']")
    WebElement checkbox1;

    @FindBy(xpath = "//input[@id='checkbox2' and @id='checkbox2']")
    WebElement checkbox2;

    @FindBy(xpath = "//button[@id='toggleCheckbox']")
    WebElement buttonToggleCheckBox;

    @FindBy(xpath = "//button[@id='loadContent']")
    WebElement buttonToggleAJAX;

    @FindBy(xpath = "//div[@id='ajaxContent']")
    WebElement textAJAX;

    @FindBy(xpath = "//span[@id='statusLabel']")
    WebElement textStatus;

    public void clickLinkHiddenAJAX() {
        linkHiddenAJAX.click();
    }

    public String getTextHeader() {
        try {
            clickLinkHiddenAJAX();
            wait.until(ExpectedConditions.visibilityOf(textHeader));
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public String getTextStatus() {
        wait.until(ExpectedConditions.visibilityOf(textStatus));
        return textStatus.getText();
    }

    public void setInput(String input1, String input2) {
        clickLinkHiddenAJAX();
        inputBox1.sendKeys(input1);
        buttonToggleInput.click();
        System.out.println("Input box 2 is displayed: " + inputBox2.isDisplayed());
        inputBox2.sendKeys(input2);
        System.out.println("Status: " + getTextStatus());
    }

    public void setCheckbox() {
        clickLinkHiddenAJAX();
        checkbox1.click();
        System.out.println("Checkbox1 is selected: " + checkbox1.isSelected());
        buttonToggleCheckBox.click();

        wait.until(ExpectedConditions.visibilityOf(checkbox2));
        System.out.println("Checkbox2 is displayed: " + checkbox2.isDisplayed());
        checkbox2.click();
        System.out.println("Checkbox2 is selected: " + checkbox2.isSelected());
    }

    public void setLoadAJAX() throws InterruptedException {
        clickLinkHiddenAJAX();
        wait.until(ExpectedConditions.visibilityOf(buttonToggleAJAX));
        System.out.println("Before clicking button AJAX: " + getTextStatus());
        buttonToggleAJAX.click();
        Thread.sleep(3000);
        System.out.println("After clicking button AJAX: " + getTextStatus());
        wait.until(ExpectedConditions.visibilityOf(textAJAX));
        System.out.println(textAJAX.getText());
    }
}
