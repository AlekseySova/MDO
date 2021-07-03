package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

public class MiyDimOnlineManagerSideMenu {

    private By accurualItemMenuLocator = By.xpath(".//*[@data-original-title='Статті нарахувань']");
    private By buildingObjectsMenuLocator = By.xpath(".//a[contains(@data-original-title, 'єкти нерухомості')]");
    private By settlementPeriodsLocator = By.xpath(".//ul[@class='menu-submenu']//a[contains(@href,'/uk/accounting/periods')]");
    private By journalOfOperationsLocator = By.xpath(".//a[contains(@href,'/uk/transactions')]");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineManagerSideMenu(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void toAccurualItem(){

        WebElement accrualItemMenu = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(accurualItemMenuLocator));

        accrualItemMenu.click();

    }

    public void toBuildingObjects(){

        WebElement buildingObjectsMenu = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(buildingObjectsMenuLocator));

        buildingObjectsMenu.click();

    }

    public void toSettlementPeriods(){

        WebElement settlementPeriodsMenu = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(settlementPeriodsLocator));

        settlementPeriodsMenu.click();

    }

    public void toJournalOfOperations(){

        WebElement journalOfOperationsMenu = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(journalOfOperationsLocator));

        journalOfOperationsMenu.click();

    }

}
