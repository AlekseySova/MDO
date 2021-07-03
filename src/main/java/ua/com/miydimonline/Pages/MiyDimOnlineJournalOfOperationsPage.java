package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

import java.util.ArrayList;
import java.util.List;

public class MiyDimOnlineJournalOfOperationsPage {

    By filterPALocator = By.xpath(".//*[@aria-label='Столбец Особовий рахунок, Фильтр']//input[@tabindex='0']");
    By filterTypeOperationLocator = By.xpath(".//*[@aria-label='Столбец Тип операції, Фильтр']//*[@class='dx-dropdowneditor-icon']");
    By filterTypeReceiptLocator = By.xpath(".//*[@class='dx-item-content dx-list-item-content' and text()='Рахунок']");
    By filterOperationDataLocator = By.xpath(".//*[@aria-label='Столбец Дата проведення операції, Фильтр']");
    By filterOperationDataStartLocator = By.xpath(".//*[@class='dx-editor-container dx-datagrid-filter-range-start']//input[@tabindex='0']");
    By filterOperationDataEndLocator = By.xpath(".//*[@class='dx-editor-container dx-datagrid-filter-range-end']//input[@tabindex='0']");
    By viewReceiptIconLocator = By.xpath(".//*[@class='dx-datagrid-content dx-datagrid-content-fixed dx-pointer-events-target']//a[contains(@href,'/uk/documents/details')]");



    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineJournalOfOperationsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void goToReceipt(String month, String year){
        WebDriverUtil util = new WebDriverUtil(webDriver);

        WebElement filterPAInput = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(filterPALocator));

        filterPAInput.click();

        filterPAInput.sendKeys("5002"+ Keys.ENTER);

        WebElement filterTypeOperation = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(filterTypeOperationLocator));

        filterTypeOperation.click();

        WebElement filterTypeReceipt = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(filterTypeReceiptLocator));

        filterTypeReceipt.click();

        WebElement filterOperationData = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(filterOperationDataLocator));

        filterOperationData.click();

        WebElement filterOperationDataStart = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(filterOperationDataStartLocator));

        filterOperationDataStart.click();

        filterOperationDataStart.sendKeys("01."+month+"."+year);

        WebElement filterOperationDataEnd = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(filterOperationDataEndLocator));

        filterOperationDataEnd.click();

        filterOperationDataEnd.sendKeys("01."+month+"."+year);

        WebElement viewReceiptIcon = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(viewReceiptIconLocator));

        viewReceiptIcon.click();

        ArrayList<String> browserTabs = new ArrayList<String> (webDriver.getWindowHandles());

        webDriver.switchTo().window(browserTabs.get(1));

        System.out.println(webDriver.getTitle());
    }


}
