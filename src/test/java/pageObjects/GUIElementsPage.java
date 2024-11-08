package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GUIElementsPage extends BasePage {

    public GUIElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Automation Testing Practice']")
    WebElement firstHeading;

    @FindBy(xpath = "//span[normalize-space()='For Selenium, Cypress & Playwright']")
    WebElement secondHeading;

    @FindBy(xpath = "//input[@id='name']")
    WebElement textName;

    @FindBy(xpath = "//input[@id='email']")
    WebElement textEmail;

    @FindBy(xpath = "//input[@id='phone']")
    WebElement textPhone;

    @FindBy(xpath = "//textarea[@id='textarea']")
    WebElement textAddress;

    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> listRadioButton;

    @FindBy(xpath = "//input[@class='form-check-input' and @type='checkbox']")
    List<WebElement> listCheckbox;

    @FindBy(xpath = "//select[@id='country']")
    WebElement selectCountry;

    @FindBy(xpath = "//select[@id='colors']//option")
    List<WebElement> selectColor;

    @FindBy(xpath = "//input[@id='datepicker']")
    WebElement inputDate1;

    @FindBy(xpath = "//span[@class='ui-datepicker-month']")
    WebElement textActualMonth1;

    @FindBy(xpath = "//span[@class='ui-datepicker-year']")
    WebElement textActualYear1;

    @FindBy(xpath = "//input[@id='txtDate']")
    WebElement inputDate2;

    @FindBy(xpath = "//select[@aria-label='Select month']")
    WebElement textActualMonth2;

    @FindBy(xpath = "//select[@aria-label='Select year']")
    WebElement textActualYear2;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//tbody//tr//td")
    List<WebElement> textActualDate;

    @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
    WebElement buttonNext;

    @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']")
    WebElement buttonPrevious;

    public String getFirstHeading() {
        try {
            return firstHeading.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public String getSecondHeading() {
        try {
            return secondHeading.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void setTextName(String name) {
        textName.sendKeys(name);
    }

    public void setTextEmail(String email) {
        textEmail.sendKeys(email);
    }

    public void setTextPhone(String phone) {
        textPhone.sendKeys(phone);
    }

    public void setTextAddress(String address) {
        textAddress.sendKeys(address);
    }

    public void setGender() {
        for(WebElement gender : listRadioButton) {
            // System.out.println(gender.getAttribute("value"));
            if(gender.getAttribute("value").equals("female")) {
                gender.click();
                break;
            }
        }
    }

    public void setDays() {
        wait.until(ExpectedConditions.visibilityOfAllElements(listCheckbox));
        // click all checkboxes
        for(int day = 0; day < listCheckbox.size(); day++) {
            listCheckbox.get(day).click();
            String value = listCheckbox.get(day).getAttribute("value");
            System.out.println("Clicked checkbox at index: " + day + " | Day: " + value);
        }

//        // click first 3 checkboxes
//        for(int day = 0; day < 3; day++) {
//            listCheckbox.get(day).click();
//            System.out.println("Click first 3 checkboxes");
//        }

        // click 5 checkboxes
//        for(int day = 0; day < 5; day++) {
//            listCheckbox.get(day).click();
//            System.out.println("Check: " + day);
//        }

        // then uncheck
//        for(int day = 0; day < listCheckbox.size(); day++) {
//            if(listCheckbox.get(day).isSelected()) {
//                listCheckbox.get(day).click();
//                System.out.println("Uncheck: " + day);
//            }
//        }

        // click last 3 checkboxes
//        for (int day = 4; day < listCheckbox.size(); day++) {
//            listCheckbox.get(day).click();
//            String value = listCheckbox.get(day).getAttribute("value");
//            System.out.println("Check: " + value);
//        }
    }

    public void setSelectCountry() {
        Select sel = new Select(selectCountry);
        List<WebElement> listCountry = sel.getOptions();
        // System.out.println(listCountry.size());

        for(int country = 0; country < listCountry.size(); country++) {
            // System.out.println(listCountry.get(country).getText()); // Australia
            String option = listCountry.get(country).getText();
            if(option.equals("Australia")) {
                listCountry.get(country).click();
                break;
            }
        }
    }

    public void setSelectColor() {
        // System.out.println(selectColor.size());
        for(int color = 0; color < selectColor.size(); color++) {
            System.out.println(selectColor.get(color).getText());
            String option = selectColor.get(color).getText();
            if(option.equals("Green")) {
                selectColor.get(color).click();
                break;
            }
       }
    }

    public void setDatePicker1(String date, String month, String year) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(inputDate1));
        wait.until(ExpectedConditions.elementToBeClickable(inputDate1)).click();

        while(true) {
            String currentMonth = textActualMonth1.getText();
            String currentYear = textActualYear1.getText();

            // if target month & year same as current month & year
            if(currentMonth.equals(month) && currentYear.equals(year)) {
                System.out.println("Current month: " + currentMonth + " | Current year: " + currentYear);
                System.out.println("Target month: " + month + " | Target year: " + year);
                break; // stop; exit from the loop
            }
            // if false
            // buttonNext.click(); // forward
            buttonPrevious.click(); // backward
            Thread.sleep(2000);
        }
        // select the date
        for(WebElement d : textActualDate) {
            if(d.getText().equals(date)) {
                d.click();
                break;
            }
        }
    }

    public void setDatePicker2(String date, String month, String year) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(inputDate2));
        wait.until(ExpectedConditions.elementToBeClickable(inputDate2)).click();

        while(true) {

            Select selMonth = new Select(textActualMonth2);
            String currentMonth = selMonth.getFirstSelectedOption().getText();

            Select selYear = new Select(textActualYear2);
            String currentYear = selYear.getFirstSelectedOption().getText();

            // if target month & year same as current month & year
            if(currentMonth.equals(month) && currentYear.equals(year)) {
                System.out.println("Current month: " + currentMonth + " | Current year: " + currentYear);
                System.out.println("Target month: " + month + " | Target year: " + year);
                break; // stop; exit from the loop
            }
            // if false
            buttonNext.click(); // forward
            // buttonPrevious.click(); // backward
            Thread.sleep(2000);
        }
        // select the date
        for(WebElement d : textActualDate) {
            if(d.getText().equals(date)) {
                d.click();
                break;
            }
        }
    }
}
