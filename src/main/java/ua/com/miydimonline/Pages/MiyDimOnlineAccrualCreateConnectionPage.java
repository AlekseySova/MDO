package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

import java.awt.*;
import java.util.List;

public class MiyDimOnlineAccrualCreateConnectionPage {

    private By editBtnLocator = By.xpath(".//*[@aria-label='Редагувати']");
    private By acсruallConnectonDataTableLocator = By.xpath(".//*[@class='dx-datagrid-rowsview dx-datagrid-nowrap dx-scrollable dx-visibility-change-handler dx-scrollable-both dx-scrollable-simulated dx-scrollable-customizable-scrollbars']//tbody");
    private By saveBtnLocator = By.xpath(".//*[@class='dx-datagrid-toolbar-button dx-edit-button dx-datagrid-save-button dx-button dx-button-normal dx-button-mode-contained dx-widget m-btn m-btn-secondary dx-button-has-text']");
    private By dataInputLocator = By.xpath(".//input[@class='dx-texteditor-input' and @role='combobox']");
    private By startBalanceLocator = By.xpath(".//input[@class='dx-texteditor-input' and @role='spinbutton']");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineAccrualCreateConnectionPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void EditMode(){

        WebElement editBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(editBtnLocator));

        editBtn.click();

    }

    public void addAccrualConnection(String pANumber, String startData, String startBalance, String startSquare){

        WebElement acсruallConnectionDataTable = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(acсruallConnectonDataTableLocator));

        List<WebElement> dataRows = acсruallConnectionDataTable.findElements(By.tagName("tr"));

        int rowCount = dataRows.size();

        System.out.println("Rows count = " + rowCount);

        for (int row=0; row<rowCount; row++){

            List<WebElement> dataCols = dataRows.get(row).findElements(By.tagName("td"));

                System.out.println("Cols in row = " + dataCols.size());

                System.out.println("Personal number = " + dataCols.get(4).getText());

                if(pANumber.equals(dataCols.get(4).getText())){

                    System.out.println("Equal");

                    dataCols.get(6).click();

                    WebElement colDataInput = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(dataInputLocator));

                    colDataInput.sendKeys(startData);

                    dataCols.get(7).click();

                    WebElement colBalanceInput = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(startBalanceLocator));

                    colBalanceInput.sendKeys(startBalance);

                    dataCols.get(8).click();

                    WebElement colSquareInput = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(startBalanceLocator));

                    colSquareInput.sendKeys(startSquare);

                    break;

                }


        }

    }

    public void saveConnection(){

        WebElement saveBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(saveBtnLocator));

        saveBtn.click();

        WebElement editBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(editBtnLocator));

    }


}
