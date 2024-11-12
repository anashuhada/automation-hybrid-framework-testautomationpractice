package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PaginationWebTablePage extends BasePage {

    public PaginationWebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='table-container']")
    WebElement table;

    @FindBy(xpath = "//table[@id='productTable']//tbody//tr")
    List<WebElement> rows;

    @FindBy(xpath = "//ul[@id='pagination']//li")
    List<WebElement> buttonPagination;

    public void paginationWebTable() throws InterruptedException {
        // System.out.println(buttonPagination.size()); // 4
        System.out.println("ID" + "\t" + "Name" + "\t" + "Price");

        for(int i = 1; i <= buttonPagination.size(); i++) {
            WebElement buttonPage = driver.findElement(By.xpath("//ul[@id='pagination']//li[" + i + "]"));
            buttonPage.click();
            // System.out.println("Button clicked: " + i);
            Thread.sleep(2000);

            wait.until(ExpectedConditions.visibilityOf(table));

            // System.out.println("Page " + i + " has " + rows.size()); // 5

            for(WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.xpath("td"));

                String id = columns.get(0).getText();
                // System.out.println("ID: " + id);

                for (WebElement column : columns) {
                    System.out.print(column.getText() + "\t");
                }

                List<WebElement> checkboxes = row.findElements(By.xpath(".//input[@type='checkbox']"));
                if (id.equals("10") || id.equals("15") || id.equals("20")) {
                    for (WebElement checkbox : checkboxes) {
                        if(!checkbox.isSelected()) {
                            checkbox.click();
                            Thread.sleep(2000);
                            System.out.println("Checkbox is selected: " + checkbox.isSelected());
                        } else {
                            System.out.println("Checkbox has already selected");
                        }
                    }
                } else {
                    for (WebElement checkbox : checkboxes) {
                        System.out.println("Checkbox is selected: " + checkbox.isSelected());
                    }
                }
            }
            System.out.println();
        }
    }
}
