package ua.com.miydimonline.Pages;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

public class MiyDimOnlineRegistrationThreeStepsPage {

    private By edrpouFldLocator = By.xpath(".//*[@class='form-control' and @name='Edrpou']");
    private By personalAccountCountFldLocator = By.xpath(".//*[@id='PersonalAccountCount']");
    private By responsiblePersonFldLocator = By.xpath(".//*[@id='ResponsiblePerson']");
    private By companyAddressFldLocator = By.xpath(".//*[@id='CompanyAddress']");
    private By bankAccountFldLocator = By.xpath(".//*[@id='BankAccount']");
    private By bankNameFldLocator = By.xpath(".//*[@id='BankName']");
    private By dateOfContractFldLocator = By.xpath(".//*[@id='AccountingStartDate']");
    private By confirmBtnLocator = By.xpath(".//*[@class='btn btn-success btn-form-requisites']");
    private By contractDownloadBtnLocator = By.xpath(".//*[@class='btn btn-success' and @title='Завантажити']");
    private By logOutBtnLocator = By.xpath(".//*[@class='not-dashed']");



    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineRegistrationThreeStepsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }


    public void fillEdrpou(String edrpou){

        WebElement edrpouFld = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(edrpouFldLocator));

        BigDecimal edrpouDouble = new BigDecimal(edrpou);

        edrpou = edrpouDouble.toString();

        System.out.println("Last edrpou = "+ edrpouDouble);

        edrpouFld.sendKeys(edrpou);

    }

    public void fillAccountCounts(String pACount){

       WebElement personalAccountCountFld = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(personalAccountCountFldLocator));

       personalAccountCountFld.sendKeys(pACount);
    }

    public void fillresponsiblePerson(String responsiblePerson){

        WebElement responsiblePersonFld = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(responsiblePersonFldLocator));

        responsiblePersonFld.sendKeys(responsiblePerson);

    }

    public void fillCompanyAddress (String companyAddress){

        WebElement companyAddressFld = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(companyAddressFldLocator));

        companyAddressFld.sendKeys(companyAddress);

    }

    public void fillBankAccount (String bankAccount){

        WebElement bankAccountFld = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(bankAccountFldLocator));

        bankAccountFld.sendKeys(bankAccount);

    }

    public void fillBankName (String bankName){

        WebElement bankNameFld = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(bankNameFldLocator));

        bankNameFld.sendKeys(bankName);

    }

    public void fillDataOfContract (){

        Date date = new Date();

        SimpleDateFormat dataFormat = new SimpleDateFormat("dd.MM.yyyy");

        String strDate= dataFormat.format(date);


        WebElement dataOfContractFld = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(dateOfContractFldLocator));

        dataOfContractFld.sendKeys(strDate);

    }

    public void pressConfirmBtn (){

        WebElement confirmBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(confirmBtnLocator));

        confirmBtn.click();
    }

    public void contractDownload(){

        WebElement contractDownloadBtn = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(contractDownloadBtnLocator));

        contractDownloadBtn.click();

    }

    public void exitAccount(){

       List<WebElement> logOutBtn = webDriverUtil.waitForExpectedConList(ExpectedConditions.presenceOfAllElementsLocatedBy(logOutBtnLocator));

       logOutBtn.get(1).click();

    }



}
