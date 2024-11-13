package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.UploadFilesPage;
import testBase.BaseClass;

public class UploadFilesTest extends BaseClass {

    @Test(groups = "Master")
    public void verifyUploadFiles() {
        SoftAssert softAssert = new SoftAssert();

        logger.info("verifyUploadFiles started.");
        UploadFilesPage uf = new UploadFilesPage(driver);
        String header = uf.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Upload Files", "Mismatched.");

        uf.singleFile("/Volumes/KINGSTON/Software Testing/Automation Testing/txt_file1");
        uf.multipleFile();

        softAssert.assertAll();
        logger.info("verifyUploadFiles finished.");
    }
}
