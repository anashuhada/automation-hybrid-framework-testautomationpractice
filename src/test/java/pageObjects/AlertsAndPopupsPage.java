package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AlertsAndPopupsPage extends BasePage {

    public AlertsAndPopupsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Alerts & Popups']")
    WebElement textHeader;

    @FindBy(xpath = "//button[@id='alertBtn']")
    WebElement buttonSimpleAlert;

    @FindBy(xpath = "//button[@id='confirmBtn']")
    WebElement buttonConfirmAlert;

    @FindBy(xpath = "//button[@id='promptBtn']")
    WebElement buttonPromptAlert;

    @FindBy(xpath = "//button[normalize-space()='New Tab']")
    WebElement buttonNewTab;

    @FindBy(xpath = "//button[@id='PopUp']")
    WebElement buttonNewWindow;

    @FindBy(xpath = "//p[@id='demo']")
    WebElement textDisplayed;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public String textDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(textDisplayed));
            System.out.println(textDisplayed.getText());
            return textDisplayed.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void simpleAlert() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(buttonSimpleAlert));
        wait.until(ExpectedConditions.elementToBeClickable(buttonSimpleAlert)).click();

        Alert al = driver.switchTo().alert();
        System.out.println(al.getText());
        Thread.sleep(2000);
        al.accept(); // OK
        textDisplayed();
    }

    public void confirmAlert() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(buttonConfirmAlert));
        wait.until(ExpectedConditions.elementToBeClickable(buttonConfirmAlert)).click();

        Alert al = driver.switchTo().alert();
        System.out.println(al.getText());
        Thread.sleep(2000);
        al.dismiss(); // cancel
        textDisplayed();
    }

    public void promptAlert(String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(buttonPromptAlert));
        wait.until(ExpectedConditions.elementToBeClickable(buttonPromptAlert)).click();

        Alert al = driver.switchTo().alert();
        System.out.println(al.getText());
        Thread.sleep(2000);
        // al.sendKeys(""); // clear
        al.sendKeys(text);
        al.accept();
        textDisplayed();
    }

    public void newTab() {
        wait.until(ExpectedConditions.visibilityOf(buttonNewTab));
        wait.until(ExpectedConditions.elementToBeClickable(buttonNewTab)).click();

        Set<String> windowId = driver.getWindowHandles();

        // approach 1
//        List<String> winId = new ArrayList(windowId);
//        String winParent = winId.get(0);
//        driver.switchTo().window(winParent);
//        System.out.println("This is window parent: " + driver.getTitle());
//
//        String winChild = winId.get(1);
//        driver.switchTo().window(winChild);
//        System.out.println("This is window child: " + driver.getTitle());
//        driver.close();
//
//        driver.switchTo().window(winParent);
//        System.out.println("Switch back to window parent.");

        // approach 2
        for(String id : windowId) {
            String title = driver.switchTo().window(id).getTitle();
            if(title.equals("Your Store")) {
                driver.quit();
            }
        }
    }

    public void newWindow() {
        wait.until(ExpectedConditions.visibilityOf(buttonNewWindow));
        wait.until(ExpectedConditions.elementToBeClickable(buttonNewWindow)).click();

        Set<String> windowId = driver.getWindowHandles();
        List<String> winId = new ArrayList(windowId);
        String winParent = winId.get(0);
        driver.switchTo().window(winParent);
        System.out.println("This is parent window: " + driver.getTitle());

        String winPopup = winId.get(1);
        driver.switchTo().window(winPopup);
        System.out.println("This is popup window: " + driver.getTitle());
        driver.close();
        System.out.println("Popup window closed.");

        driver.switchTo().window(winParent);
        System.out.println("Switch back to parent window.");
    }

//    public void newWindow() {
//        wait.until(ExpectedConditions.visibilityOf(buttonNewWindow));
//        wait.until(ExpectedConditions.elementToBeClickable(buttonNewWindow)).click();
//
//        // Store the parent window handle
//        String winParent = driver.getWindowHandle();
//
//        // Wait for the new window to open and then get all window handles
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//        Set<String> windowHandles = driver.getWindowHandles();
//
//        // Identify the popup window handle
//        for (String handle : windowHandles) {
//            if (!handle.equals(winParent)) {
//                driver.switchTo().window(handle);
//                System.out.println("This is the popup window: " + driver.getTitle());
//
//                // Close the popup window
//                driver.close();
//                System.out.println("Popup window closed.");
//
//                // Break after closing to avoid re-switching accidentally
//                break;
//            }
//        }
//
//        // Switch back to the parent window
//        driver.switchTo().window(winParent);
//        System.out.println("Switched back to the parent window: " + driver.getTitle());
//    }

}
