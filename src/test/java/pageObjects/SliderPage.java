package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Slider']")
    WebElement textHeader;

    @FindBy(xpath = "//div[@id='HTML7']//span[1]")
    WebElement sliderMin;

    @FindBy(xpath = "//div[@id='HTML7']//span[2]")
    WebElement sliderMax;

    @FindBy(xpath = "//input[@id='amount']")
    WebElement textResult;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void slider() {
        System.out.println("Min slider before sliding: " + sliderMin.getLocation() + " | Max slider before sliding: " + sliderMax.getLocation()); // (1167, 1945) | (1296, 1945)
        // wait.until(ExpectedConditions.visibilityOf(textResult));
        System.out.println("Price range before sliding: " + textResult.getAttribute("value"));

        int xOffsetMin = 10;
        int xOffsetMax = -50;
        int yOffset = 0;

        act.dragAndDropBy(sliderMin, xOffsetMin, yOffset).perform();
        System.out.println("Min slider after sliding: " + sliderMin.getLocation());

        act.dragAndDropBy(sliderMax, xOffsetMax, yOffset).perform();
        System.out.println("Max slider after sliding: " + sliderMax.getLocation());

        // wait.until(ExpectedConditions.visibilityOf(textResult));
        System.out.println("Price range after sliding: " + textResult.getAttribute("value"));
    }
}
