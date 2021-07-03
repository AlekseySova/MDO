package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

public class MiyDimOnlineAccrualCreatePage {

    private By accrualTmpHousekeepingBtnLocator = By.xpath(".//*[@class='item-template']//P[text()='Утримання будинку та прибудинкової території']");
    private By accrualSaveBtnLocator= By.xpath(".//*[@class='m-btn m-btn-primary']");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineAccrualCreatePage(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void addHousekeepingAccurualItem(){

        WebElement accrualTempHousekeepingBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(accrualTmpHousekeepingBtnLocator));

        accrualTempHousekeepingBtn.click();

        WebElement accrualSaveBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(accrualSaveBtnLocator));

        accrualSaveBtn.click();

    }
}
