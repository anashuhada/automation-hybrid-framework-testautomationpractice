package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SVGElementsPage extends BasePage {

    public SVGElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='SVG Elements']")
    WebElement textHeader;

    @FindBy(xpath = "//div[@class='svg-container']//*[name()='circle']")
    WebElement svgCircle;

    @FindBy(xpath = "//div[@class='svg-container']//*[name()='rect']")
    WebElement svgRectangle;

    @FindBy(xpath = "//div[@class='svg-container']//*[name()='polygon']")
    WebElement svgPolygon;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void svg() {
        boolean cir = svgCircle.isDisplayed();
        System.out.println("SVG Circle is displayed: " + cir);

        boolean rec = svgRectangle.isDisplayed();
        System.out.println("SVG Rectangle is displayed: " + rec);

        boolean pol = svgPolygon.isDisplayed();
        System.out.println("SVG Polygon is displayed: " + pol);
    }
}
