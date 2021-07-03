package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

import java.util.List;

public class MiyDimOnlineMainPage {

    private By loginBtnLocator = By.xpath(".//*[@class='btn-popup btn-login']");
    private By loginEmailLocator = By.id("Email");
    private By loginPasswordLocator = By.xpath(".//*[@id='Password']");
    private By loginEntryLocator = By.xpath(".//button[@class='btn btn-success btn-md']");
    private By loginErrorLabelLocator = By.xpath(".//*[@class='validation-summary-errors alert alert-danger alert-dismissable']/ul/li");
    private By companyRegistrationListLocator = By.xpath(".//li[@class='dropdown open-onhover']");
    private By companyRegButtonLocator = By.xpath(".//a[@class='btn-reg-com']");
    private By emptyEmailValidationLocator = By.xpath(".//*[@Class='validation-summary-errors alert alert-danger alert-dismissable']/ul/li");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineMainPage(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void openPage(String url){

        webDriver.get(url);

    }

    public void login(String mail, String password){

        Actions actions = new Actions(webDriver);

        WebElement loginBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(loginBtnLocator));

        //WebElement loginEmail= webDriver.findElement(loginEmailLocator);

        actions.moveToElement(loginBtn).click().perform();

        WebElement loginPassword =  webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(loginPasswordLocator));
        WebElement loginEntry = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(loginEntryLocator));


        List<WebElement> loginEmailList = webDriverUtil.waitForExpectedConList(ExpectedConditions.presenceOfAllElementsLocatedBy(loginEmailLocator));
        loginEmailList.get(1).sendKeys(mail);
        //loginEmail.click();
        //loginEmail.sendKeys(mail);
        loginPassword.sendKeys(password);
        loginEntry.click();


    }

    public void loginOnLoginPage(String mail, String password){

        WebElement loginEmailFld = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(loginEmailLocator));
        WebElement loginPasswordFld = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(loginPasswordLocator));
        WebElement loginEntryBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(loginEntryLocator));

        loginEmailFld.sendKeys(mail);
        loginPasswordFld.sendKeys(password);
        loginEntryBtn.click();

    }

    public String unValideLoginConfirm() {
        List<WebElement> loginErrorLabel = webDriverUtil.waitForExpectedConList(ExpectedConditions.presenceOfAllElementsLocatedBy(loginErrorLabelLocator));
        int validationFieldsCount = loginErrorLabel.size();
        String actualResult= "";

        if (validationFieldsCount == 1) {

            actualResult = loginErrorLabel.get(0).getText();

        } else {

            for (int i = 0; i< validationFieldsCount-1; i++){

                if(loginErrorLabel.get(i).getText().equals("Будь ласка, введіть коректну електронну адресу і пароль облікового запису") ){

                    actualResult = loginErrorLabel.get(i).getText();

                }

            }
        }

        return actualResult;
    }

    public String emptyEmailValidation(){


        WebElement emptyEmailMessage = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(emptyEmailValidationLocator));

        String actualResult = emptyEmailMessage.getText();


        return actualResult;
    }

    public String emptyPasswordValidation(){

        WebElement emptyPasswordMessage = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(emptyEmailValidationLocator));

        String actualResult = emptyPasswordMessage.getText();

        return actualResult;
    }

    public void companyRegButton(){

        List<WebElement> companyRegistrationList = webDriverUtil.waitForExpectedConList(ExpectedConditions.presenceOfAllElementsLocatedBy(companyRegistrationListLocator));

        WebElement companyRegElement = companyRegistrationList.get(1);

        companyRegElement.click();

        WebElement companyRegistrationButton = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(companyRegButtonLocator));

        companyRegistrationButton.click();
    }

}
