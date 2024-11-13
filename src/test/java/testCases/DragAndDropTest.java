package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.DragAndDropPage;
import testBase.BaseClass;

public class DragAndDropTest extends BaseClass {

    @Test(groups = "Master")
    public void verifyDragAndDrop() {
        SoftAssert softAssert = new SoftAssert();

        logger.info("verifyDragAndDrop started.");
        DragAndDropPage dd = new DragAndDropPage(driver);
        String header = dd.getTextHeader();
        // System.out.println(header);
        softAssert.assertEquals(header, "Drag and Drop", "Incorrect.");

        dd.dragAndDrop();

        softAssert.assertAll();
        logger.info("verifyDragAndDrop finished.");
    }
}
