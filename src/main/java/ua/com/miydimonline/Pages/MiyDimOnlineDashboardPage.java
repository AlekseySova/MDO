package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

import java.util.List;

public class MiyDimOnlineDashboardPage {

    private By clientNameLocator = By.xpath(".//*[@class='name' and @title]");
    private By buildingObjectsRefLocator = By.xpath(".//a[@href='/Сова10005/uk/nextbuildings']");
    private By profileMenuButtonLocator = By.xpath(".//*[@Class='actions dropdown-toggle dropdown-toggle-split']");
    private By profileExitItemLocator = By.xpath(".//*[@Class='dropdown-menu dropdown-menu-right']//a[@href=\"javascript:$('.logout-form').submit()\"]");

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

    public void goToBuildingObjects(){

        WebElement buildingObjectsRef = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(buildingObjectsRefLocator));

        buildingObjectsRef.click();
    }

    public void accountExit(){

        WebElement profileMenuButton = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(profileMenuButtonLocator));

        profileMenuButton.click();

        WebElement profileMenu = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(profileExitItemLocator));

        profileMenu.click();

    }

}
