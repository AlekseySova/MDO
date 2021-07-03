package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

public class MiyDimOnlineAccrualConnectionPage {

    private By addConnectionButtonLocator = By.xpath(".//*[@class='group-card-list']/*[@class='group-card-item modern-panel modern-panel-add']/a");
    private By chooseAccrualBtnLocator = By.xpath(".//*[@class='dx-item dx-list-item']//*[text()='Утримання будинку']");
    private By agreeBtnLocator = By.xpath(".//button[@data-btn='proceed']");


    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineAccrualConnectionPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void addAccrualConnection(){

        WebElement addConnectionBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(addConnectionButtonLocator));

        addConnectionBtn.click();

        WebElement chooseAccrualBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(chooseAccrualBtnLocator));

        chooseAccrualBtn.click();

        WebElement agreeBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(agreeBtnLocator));

        agreeBtn.click();
    }

}
