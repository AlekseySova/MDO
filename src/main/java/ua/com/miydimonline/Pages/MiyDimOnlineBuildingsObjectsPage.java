package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

import java.util.Set;

public class MiyDimOnlineBuildingsObjectsPage {

    private By buildingAddressFilterLocator = By.xpath(".//td[ @aria-label='Столбец Адреса, Фильтр']");
    private By buildingAddressSearchStreetLocator = By.xpath(".//div[@id='CompanyStreet']//input[@class='dx-texteditor-input']");
    private By getBuildingAddressSearchStreetItemLocator = By.xpath(".//div[@class='dx-item-content dx-list-item-content' and text()='Леніна']");
    private By buildingAddressSearchSubmitButtonLocator = By.xpath(".//form[@class='superviser-enabled superviserextended-enabled superviserresident-enabled']//button[@class='m-btn m-btn-primary']");
    private By buildingItemLinkLocator = By.xpath(".//a[@href='/%d0%a1%d0%be%d0%b2%d0%b010005/uk/nextbuildings/buildingunit?buildingType=1&buildingId=4636']");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineBuildingsObjectsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void goToFlats(String Street){

        WebDriverUtil util = new WebDriverUtil(webDriver);

        WebElement buildingAddressFilter = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(buildingAddressFilterLocator));

        buildingAddressFilter.click();

        WebElement buildingAdressSearchStreet = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(buildingAddressSearchStreetLocator));

        buildingAdressSearchStreet.sendKeys(Street);

        WebElement buildingAdressSearchStreetItem = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(getBuildingAddressSearchStreetItemLocator));

        buildingAdressSearchStreetItem.click();

        WebElement buildingAddressSearchSubmitButton = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(buildingAddressSearchSubmitButtonLocator));

        buildingAddressSearchSubmitButton.click();

        String oldTab = String.valueOf(webDriver.getWindowHandles());

        try {
            WebElement buildingItemLink = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(buildingItemLinkLocator));
            buildingItemLink.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
            {
                WebElement buildingItemLink = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(buildingItemLinkLocator));
                buildingItemLink.click();
        }

        util.switchToNewTab(oldTab);

    }

}
