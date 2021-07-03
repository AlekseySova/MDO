package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

import java.awt.*;

import java.util.List;
import java.util.Set;

public class MiyDimOnlineBuildingsObjectsPage {

    private By buildingAddressFilterLocator = By.xpath(".//td[ @aria-label='Столбец Адреса, Фильтр']");
    private By buildingAddressSearchStreetLocator = By.xpath(".//div[@id='CompanyStreet']//input[@class='dx-texteditor-input']");
    private By getBuildingAddressSearchStreetItemLocator = By.xpath(".//div[@class='dx-item-content dx-list-item-content' and text()='Леніна']");
    private By buildingAddressSearchSubmitButtonLocator = By.xpath(".//form[@class='superviser-enabled superviserextended-enabled superviserresident-enabled']//button[@class='m-btn m-btn-primary']");
    private By buildingItemLinkLocator = By.xpath(".//a[@href='/%d0%a1%d0%be%d0%b2%d0%b010005/uk/nextbuildings/buildingunit?buildingType=1&buildingId=4636']");
    private By buildingItemCreateDropdownLocator = By.xpath(".//*[@class='dropdown']/button[@class='m-btn m-btn-primary m-btn-icon dropdown-toggle']");
    private By buildingItemCreateApartmentLocator = By.xpath(".//*[@id='addNewCondominium']");
    private By bILocalityListLocator = By.xpath(".//*[@id='CityOrCompanyCityId']");
    private By bILocalityInputLocator = By.xpath(".//*[@id='CityOrCompanyCityId']//input[@tabindex='0']");
    private By bIStreetListLocator = By.xpath(".//*[@id='StreetOrCompanyStreetId']");
    private By bIStreetInputLocator = By.xpath(".//*[@id='StreetOrCompanyStreetId']//*[@tabindex='0']");
    private By bIBuildingNumberLocator = By.xpath(".//*[@class='dx-popup-content dx-scrollable dx-scrollview dx-visibility-change-handler dx-scrollable-vertical dx-scrollable-simulated dx-scrollable-customizable-scrollbars']//input[@id='BuildingNumber']");
    private By bIapartmentNumberLocator = By.xpath(".//input[@name='ApartmentCount']");
    private By bICreatePopupSubmitBtnLocator = By.xpath(".//*[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']//button[@type='submit']");

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

    public void createApartmentHouse(String SearchItem, String cityName, String RegionName, String SearchStreet, String ResultStreet) {


        WebElement buildingItemCreateDropdown = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(buildingItemCreateDropdownLocator));

        buildingItemCreateDropdown.click();

        WebElement buildingItemCreateApartment = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(buildingItemCreateApartmentLocator));

        buildingItemCreateApartment.click();

        WebElement bILocalityList = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(bILocalityListLocator));

        bILocalityList.click();

        WebElement bISearchLocalityInput = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(bILocalityInputLocator));

        bISearchLocalityInput.sendKeys(SearchItem);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.delay(1000); // 1 SECOND

        WebElement listItemsCity = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='dx-overlay-wrapper dx-dropdowneditor-overlay dx-popup-wrapper dx-dropdownlist-popup-wrapper dx-selectbox-popup-wrapper']//*[@class='dx-item dx-list-item']//*[@class='address-item']//div[text()='" + cityName + "']")));

        listItemsCity.click();


        WebElement bIStreetList = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(bIStreetListLocator));

        bIStreetList.click();

        WebElement bIStreetInput = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(bIStreetInputLocator));

        bIStreetInput.sendKeys(SearchStreet);

        robot.delay(1000);

        WebElement streetItem = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='dx-overlay-wrapper dx-dropdowneditor-overlay dx-popup-wrapper dx-dropdownlist-popup-wrapper dx-selectbox-popup-wrapper']//*[@class='address-item']//div[text()='"+ ResultStreet +"']")));

        streetItem.click();

        WebElement buildingNumber = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(bIBuildingNumberLocator));

        buildingNumber.click();

        buildingNumber.sendKeys("5");

        WebElement apatementCount = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(bIapartmentNumberLocator));

        apatementCount.click();

        apatementCount.sendKeys("10");

        WebElement submitBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(bICreatePopupSubmitBtnLocator));

        submitBtn.click();

    }


    }

