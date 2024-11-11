package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ShadowDOMPage extends BasePage {

    public ShadowDOMPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='ShadowDOM']")
    WebElement textHeader;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void shadowMobiles() throws InterruptedException {
        Thread.sleep(1000);
        SearchContext shadow = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
        Thread.sleep(1000);
        WebElement mobile = shadow.findElement(By.cssSelector(".info"));
        String actualMobile = mobile.getText();
        String expectedMobile = "Mobiles";
        Assert.assertEquals(actualMobile, expectedMobile, "Incorrect.");
        System.out.println("This is Shadow DOM - Mobiles");
    }

    public void shadowLaptops() throws InterruptedException {
        Thread.sleep(1000);
        SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(By.cssSelector("#nested_shadow_host")).getShadowRoot();
        Thread.sleep(1000);
        WebElement laptop = shadow1.findElement(By.cssSelector(" div:nth-child(1) > div:nth-child(1)"));
        String actualLaptop = laptop.getText();
        String expectedLaptop = "Laptops";
        Assert.assertEquals(actualLaptop, expectedLaptop, "Incorrect.");
        System.out.println("This is Shadow DOM - Laptops");
    }

    public void shadowBlog() throws InterruptedException {
        Thread.sleep(1000);
        SearchContext shadow = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
        Thread.sleep(1000);
        WebElement linkBlog = shadow.findElement(By.cssSelector("a[href='https://www.pavantestingtools.com/']"));
        js.executeScript("arguments[0].click()", linkBlog);
    }

    public void shadowInputBox(String text) throws InterruptedException {
        Thread.sleep(1000);
        SearchContext shadow = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
        Thread.sleep(1000);
        WebElement textInput = shadow.findElement(By.cssSelector("input[type='text']"));
        textInput.clear();
        textInput.sendKeys(text);
    }

    public void shadowCheckbox() throws InterruptedException {
        Thread.sleep(1000);
        SearchContext shadow = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
        Thread.sleep(1000);
        WebElement checkbox = shadow.findElement(By.cssSelector("input[type='checkbox']"));
        checkbox.click();
    }

    public void shadowUploadFile(String filePath) throws InterruptedException {
        Thread.sleep(1000);
        SearchContext shadow = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
        Thread.sleep(1000);
        WebElement uploadFile = shadow.findElement(By.cssSelector("input[type='file']"));
        uploadFile.sendKeys(filePath);
    }
}
