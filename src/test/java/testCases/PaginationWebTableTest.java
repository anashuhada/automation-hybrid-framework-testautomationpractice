package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.PaginationWebTablePage;
import testBase.BaseClass;

public class PaginationWebTableTest extends BaseClass {

    @Test
    public void verifyPaginationWebTable() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        PaginationWebTablePage pwt = new PaginationWebTablePage(driver);
        pwt.paginationWebTable();

        softAssert.assertAll();
    }
}
