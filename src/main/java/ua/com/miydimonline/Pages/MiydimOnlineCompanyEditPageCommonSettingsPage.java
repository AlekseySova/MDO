package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

public class MiydimOnlineCompanyEditPageCommonSettingsPage {

    private By companyNameFieldLocator = By.xpath(".//input[@id='Name']");
    private By safeBtnLocator = By.xpath(".//button[@type='submit']");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiydimOnlineCompanyEditPageCommonSettingsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void deleteCompany(){

        WebElement companyNameField = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(companyNameFieldLocator));

        companyNameField.clear();
        companyNameField.sendKeys("delete.FOREVER.THIS.OSBB.miydomonline.dynamo-ny.com");

        WebElement safeBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(safeBtnLocator));

        safeBtn.click();
    }

}
