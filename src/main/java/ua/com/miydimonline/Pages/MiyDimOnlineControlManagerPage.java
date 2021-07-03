package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

public class MiyDimOnlineControlManagerPage {

    private By companyNameFltLocator = By.xpath(".//*[@aria-label='Столбец Назва компанії, Фильтр']//*[@class='dx-texteditor-input']");
    private By activationBtnLocator = By.xpath(".//*[@class='fa fa-power-off success']");
    private By companyActivationPopupLocator = By.xpath(".//*[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']");
    private By companyActivationPopupBtnLocator = By.xpath(".//*[@aria-label='Так']");
    private By companyEditBtnLocator = By.xpath(".//a[contains(@href,'/communityadmin/editcommunity')]");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineControlManagerPage(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void companyNameFilter(String companyName){

        WebElement companyNameFlt = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(companyNameFltLocator));

        companyNameFlt.sendKeys(companyName);

    }

    public void activateCompany(){

        WebElement activateCompanyBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(activationBtnLocator));

        activateCompanyBtn.click();

        WebElement companyActivationPopup = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(companyActivationPopupLocator));

        WebElement companyActivationPopupBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(companyActivationPopupBtnLocator));

        companyActivationPopup.click();

        companyActivationPopupBtn.click();
    }

    public void editCompany(){

        WebElement companyEditBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(companyEditBtnLocator));

        companyEditBtn.click();

    }


}
