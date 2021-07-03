package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

public class MiyDimOnlineAccuralItemPage {

    private By createAccuralItemBtnLocator = By.xpath(".//*[@data-original-title='Створення статті нарахувань']");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineAccuralItemPage(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void createAccuralItem (){

        WebElement createAccuralItemBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(createAccuralItemBtnLocator));

        createAccuralItemBtn.click();
    }

}
