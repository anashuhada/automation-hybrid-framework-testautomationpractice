package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StaticWebTablePage extends BasePage {

    public StaticWebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Static Web Table']")
    WebElement textHeader;

    @FindBy(xpath = "//table[@name='BookTable']//tr")
    List<WebElement> rows;

    @FindBy(xpath = "//table[@name='BookTable']//th")
    List<WebElement> columns;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void staticWebTable() {
        int totalRow = rows.size();
        // System.out.println("Total row: " + totalRow);

        int totalColumn = columns.size();
        // System.out.println("Total column: " + totalColumn);

        System.out.println("BookName" + "\t" + "Author" + "\t" + "Subject" + "\t" + "Price");

        // print all values from the table
        for(int r = 2; r < totalRow; r++) {
            StringBuilder rowData = new StringBuilder();
            for(int c = 1; c < totalColumn; c++) {
                String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]")).getText();
                rowData.append(value).append("\t");
            }
            System.out.println(rowData.toString().trim());
        }

        // print book names written by author Amit
//        for(int r = 2; r < totalRow; r++) {
//            String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]")).getText();
//            System.out.println(value);
//        }

        // find total price of all the books - price column
//        int total = 0;
//        for(int r = 2; r <= totalRow; r++) {
//            String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[4]")).getText();
//            total = total + Integer.parseInt(price);
//            System.out.println(total);
//        }
    }
}
