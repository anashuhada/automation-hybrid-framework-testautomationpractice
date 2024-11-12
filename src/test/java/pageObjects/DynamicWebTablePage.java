package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DynamicWebTablePage extends BasePage {

    public DynamicWebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Dynamic Web Table']")
    WebElement textHeader;

    @FindBy(xpath = "//table[@id='taskTable']//tbody//tr")
    List<WebElement> rows;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void getChromeCPU() {
        for(int r = 1; r <= rows.size(); r++) {
            WebElement name = driver.findElement(By.xpath("//table[@id='taskTable']//tbody//tr[ " + r + "]//td[1]"));

            String nameColumn = name.getText();

            if(nameColumn.equals("Chrome")) {
                String cpu = driver.findElement(By.xpath("//td[normalize-space()='Chrome']//following-sibling::*[contains(text(),'%')]")).getText();
                String value = driver.findElement(By.xpath("//strong[@class='chrome-cpu']")).getText();

                if(value.equals(cpu)) {
                    System.out.println("CPU load of Chrome process is equal.");
                } else {
                    System.out.println("CPU load of Chrome process not equal.");
                }
            }
        }
    }

    public void getFirefoxMemory() {
        for (int r = 1; r <= rows.size(); r++) {
            WebElement name = driver.findElement(By.xpath("//table[@id='taskTable']//tbody//tr[ " + r + "]//td[1]"));

            String nameColumn = name.getText();

            if (nameColumn.equals("Firefox")) {
                String memory = driver.findElement(By.xpath("//td[normalize-space()='Firefox']//following-sibling::*[contains(text(),'MB') and not(contains(text(), 'MB/s'))]")).getText();
                String value = driver.findElement(By.xpath("//strong[@class='firefox-memory']")).getText();

                if (value.equals(memory)) {
                    System.out.println("Memory Size of Firefox process is equal.");
                } else {
                    System.out.println("Memory Size of Firefox process is not equal.");
                }
            }
        }
    }

    public void getChromeNetwork() {
        for (int r = 1; r <= rows.size(); r++) {
            WebElement name = driver.findElement(By.xpath("//table[@id='taskTable']//tbody//tr[ " + r + "]//td[1]"));

            String nameColumn = name.getText();

            if (nameColumn.equals("Chrome")) {
                String network = driver.findElement(By.xpath("//td[normalize-space()='Chrome']//following-sibling::*[contains(text(),'Mbps')]")).getText();
                String value = driver.findElement(By.xpath("//strong[@class='chrome-network']")).getText();

                if (value.equals(network)) {
                    System.out.println("Network speed of Chrome process is equal.");
                } else {
                    System.out.println("Network speed of Chrome process is not equal.");
                }
            }
        }
    }

    public void getFirefoxDisk() {
        for (int r = 1; r <= rows.size(); r++) {
            WebElement name = driver.findElement(By.xpath("//table[@id='taskTable']//tbody//tr[ " + r + "]//td[1]"));

            String nameColumn = name.getText();

            if(nameColumn.equals("Firefox")) {
                String disk = driver.findElement(By.xpath("//td[normalize-space()='Firefox']//following-sibling::*[contains(text(),'MB/s')]")).getText();
                String value = driver.findElement(By.xpath("//strong[@class='firefox-disk']")).getText();

                if(value.equals(disk)) {
                    System.out.println("Disk space of Firefox process is equal.");
                } else {
                    System.out.println("Disk space of Firefox process is not equal.");
                }
            }
        }
    }
}
