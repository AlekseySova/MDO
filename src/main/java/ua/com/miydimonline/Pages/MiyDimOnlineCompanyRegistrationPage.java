package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

import java.util.List;

public class MiyDimOnlineCompanyRegistrationPage {

    private By NameLocator = By.xpath(".//input[@id='EDRPOU']");
    private By EmailRegistrationLocator = By.xpath(".//input[@id='EmailRegistration']");
    private By PhoneNumberLocator = By.xpath(".//input[@id='PhoneNumber']");
    private By RegisterButtonLocator = By.xpath(".//div[@class='submit-group text-center']/button[@class='button-site-red']");
    private By ReCaptchaLocator = By.xpath(".//div[@class='recaptcha-checkbox-spinner']");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineCompanyRegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void registration(String Name, String Email, String Phone){

        WebElement CompanyName = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(NameLocator));
        WebElement EmailRegistration = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(EmailRegistrationLocator));
        WebElement PhoneNumber = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(PhoneNumberLocator));
        //List<WebElement> ReCaptcha = (List<WebElement>) webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfAllElementsLocatedBy(ReCaptchaLocator));
        WebElement RegisterButton = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(RegisterButtonLocator));

        CompanyName.sendKeys(Name);

        EmailRegistration.sendKeys(Email);

        PhoneNumber.click();

        PhoneNumber.sendKeys(Phone);

        //int itemSize = ReCaptcha.size();

        //ReCaptcha.get(itemSize).click();

        RegisterButton.click();

    }



}
