package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.FindCellInTable;
import ua.com.miydimonline.Utils.WebDriverUtil;

import java.util.ArrayList;
import java.util.List;

public class MiyDimOnlineReceiptPage {

    By personalNumberLocator = By.xpath(".//td[contains(text(),'Особовий рахунок')]");
    By companyNameLocator = By.xpath(".//td[contains(text(),'код ЄДРПОУ')]");
    By residentAddressLocator = By.xpath(".//thead[@class='no-background-header']//*[contains(text(),'м.') or contains(text(),'c.') or contains(text(),'смт.') or contains(text(),'с-ще')]");
    By headerTableListLocator = By.xpath(".//th[text()='Стаття нарахувань']/ancestor::thead");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;

    public MiyDimOnlineReceiptPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public String getPersonalNumber() {

        WebElement personalNumberElement = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(personalNumberLocator));
        String personalNumberString = personalNumberElement.getText();

        return personalNumberString;

    }

    public String getCompanyName() {

        WebElement companyNameElement = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(companyNameLocator));
        String companyName = companyNameElement.getText();

        return companyName;
    }

    public String getResidentAddress() {

        WebElement residentAddressElement = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(residentAddressLocator));

        String residentAddressStr = residentAddressElement.getText();

        return residentAddressStr;
    }

    public void getAccrualName(String accrualName) {

        FindCellInTable findCell = new FindCellInTable(webDriver);

        By tableBodyLocator = By.xpath(".//td[text()='"+accrualName+"']/ancestor::tbody");

        List<WebElement> accrualDataList = findCell.getTableDataRowFromCellData(tableBodyLocator,accrualName,"td");

        System.out.print(accrualName+" = ");

        for (int i=0; i<accrualDataList.size(); i++){

            System.out.print(accrualDataList.get(i).getText()+ " ; ");

        }
    }
}
