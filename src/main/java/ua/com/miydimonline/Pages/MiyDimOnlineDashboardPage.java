package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

public class MiyDimOnlineDashboardPage {

    private By clientNameLocator = By.xpath(".//*[@class='name' and @title]");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineDashboardPage(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public String clientConfirm(){

        WebElement clientName = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(clientNameLocator));

        String clientNameText = clientName.getText();

        return clientNameText;

    }

}
