package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

public class MiyDimOnlineAccrualTariffsPage {

    private By tariffsEditBtnLocator = By.xpath(".//*[@aria-label='Редагувати']");
    private By addTariffBtnLocator = By.xpath(".//*[@id='gridContainer_Default-h-1-0']");
    private By tariffStartDataFldLocator = By.xpath(".//tr[@aria-rowindex='1']//td[@aria-colindex='3']");
    private By tariffStartDataInputLocator = By.xpath(".//input[@tabindex='0']");
    private By tariffTarifValueFldLocator = By. xpath(".//*[@class='dx-datagrid-rowsview dx-datagrid-nowrap dx-scrollable dx-visibility-change-handler dx-scrollable-both dx-scrollable-simulated dx-scrollable-customizable-scrollbars dx-last-row-border']//td[@aria-colindex='5']");
    private By tariffTarifValueInputLocator = By.xpath(".//input[@tabindex='0']");
    private By tariffSaveBtnLocator = By.xpath(".//*[@class ='dx-datagrid-toolbar-button dx-edit-button dx-datagrid-save-button dx-button dx-button-normal dx-button-mode-contained dx-widget m-btn m-btn-secondary dx-button-has-text']");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineAccrualTariffsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);
    }

    public void editTarifs (){

        WebElement tariffsEditBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tariffsEditBtnLocator));

        tariffsEditBtn.click();

    }

    public void addTariff(String startData, String tarifvalue){

        WebElement addTariffBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(addTariffBtnLocator));

        addTariffBtn.click();

        WebElement tariffStartDataFld = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tariffStartDataFldLocator));

        tariffStartDataFld.click();

        WebElement tariffStartDataInput = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tariffStartDataInputLocator));

        tariffStartDataInput.sendKeys(startData);

        WebElement tariffTarifValueFld = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tariffTarifValueFldLocator));

        tariffTarifValueFld.click();

        WebElement tariffTarifValueInput = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tariffTarifValueInputLocator));

        tariffTarifValueInput.sendKeys(tarifvalue);

        WebElement tariffSaveBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tariffSaveBtnLocator));

        tariffSaveBtn.click();

        WebElement tariffsEditBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tariffsEditBtnLocator));

    }


}
