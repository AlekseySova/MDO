package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

public class MiyDimOnlineAdminHeaderMenu {

    // Class of header in admin interface.
    // Created a separate class since the header elements are common for all pages of the admin panel

    private By userMenuLocator = By.xpath(".//i[@class='mi mi-caret-down']");
    private By logOutBtnLocator = By.xpath(".//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Вийти']");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineAdminHeaderMenu(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void logOut(){

        WebElement userMenu = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(userMenuLocator));

        userMenu.click();

        WebElement logOutBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(logOutBtnLocator));

        logOutBtn.click();


    }

}
