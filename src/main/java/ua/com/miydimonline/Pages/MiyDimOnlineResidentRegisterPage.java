package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

public class MiyDimOnlineResidentRegisterPage {

    private By pageTitleLocator = By.xpath(".//header[@class='section-title landing-section-title']/h2[@class = 'title-site text-left']");


    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineResidentRegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public String getPageName(){

        WebElement pageTitle = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(pageTitleLocator));

        String pageTitleText = pageTitle.getText();

        return pageTitleText;
    }

}
