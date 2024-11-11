package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

public class UploadFilesPage extends BasePage {

    public UploadFilesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Upload Files']")
    WebElement textHeader;

    @FindBy(xpath = "//input[@id='singleFileInput']")
    WebElement buttonChooseSingle;

    @FindBy(xpath = "//button[normalize-space()='Upload Single File']")
    WebElement buttonSingleFile;

    @FindBy(xpath = "//p[@id='singleFileStatus']")
    WebElement statusSingleFile;

    @FindBy(xpath = "//input[@id='multipleFilesInput']")
    WebElement buttonChooseMultiple;

    @FindBy(xpath = "//button[normalize-space()='Upload Multiple Files']")
    WebElement buttonMultipleFile;

    @FindBy(xpath = "//p[@id='multipleFilesStatus']")
    WebElement statusMultipleFile;

    public String getTextHeader() {
        try {
            return textHeader.getText();
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public void singleFile(String fileName) {
        buttonChooseSingle.sendKeys(fileName);
        buttonSingleFile.click();

        String fl = "txt_file1";
        if(statusSingleFile.getText().contains(fl)) {
            System.out.println("File is uploaded.");
        }
        else {
            System.out.println("File is not uploaded.");
        }
    }

    public void multipleFile() {
        String listFile[] = {
                "/Volumes/KINGSTON/Software Testing/Automation Testing/txt_file1",
                "/Volumes/KINGSTON/Software Testing/Automation Testing/txt_file2"
        };

        for(String file : listFile) {
            buttonChooseMultiple.sendKeys(file);
        }

        buttonMultipleFile.click();

        // approach 1
        String fl1 = "txt_file1";
        String fl2 = "txt_file2";

        if(statusMultipleFile.getText().contains(fl1) && statusMultipleFile.getText().contains(fl2)) {
            System.out.println("All files are uploaded.");
        }
        else {
            System.out.println("Some files are not uploaded.");
        }

        // approach 2
//        String fl[] = {
//                "txt_file1",
//                "txt_file2"
//        };
//
//        String text = statusMultipleFile.getText();
//        boolean allFilesUploaded = Arrays.stream(fl).allMatch(text::contains);
//        if (allFilesUploaded) {
//            System.out.println("All files are uploaded.");
//        } else {
//            System.out.println("Some files are not uploaded.");
//        }
    }
}
