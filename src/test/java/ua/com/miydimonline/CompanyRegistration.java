package ua.com.miydimonline;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ua.com.miydimonline.Core.TestListener;
import ua.com.miydimonline.Core.WebDriverTestBase;
import ua.com.miydimonline.Pages.MiyDimOnlineControlManagerPage;
import ua.com.miydimonline.Pages.MiyDimOnlineDashboardPage;
import ua.com.miydimonline.Pages.MiyDimOnlineMainPage;
import ua.com.miydimonline.Pages.MiyDimOnlineRegistrationThreeStepsPage;
import ua.com.miydimonline.Utils.WorkWithExcelFile;

@Listeners({TestListener.class})
public class CompanyRegistration extends WebDriverTestBase {

    @Test
    public void openRegistrationList() {

    MiyDimOnlineMainPage MainPage = new MiyDimOnlineMainPage(webdriver);

    MiyDimOnlineDashboardPage DashPage = new MiyDimOnlineDashboardPage(webdriver);

    MiyDimOnlineRegistrationThreeStepsPage ThreeStepsPage = new MiyDimOnlineRegistrationThreeStepsPage(webdriver);

    MiyDimOnlineControlManagerPage controlManagerPage = new MiyDimOnlineControlManagerPage(webdriver);

    WorkWithExcelFile excelFile = new WorkWithExcelFile();

    String Email = excelFile.exportFromExcelFile("Credentials","Credentials", "EmailForSmokeTest");

    String Password = excelFile.exportFromExcelFile("Credentials", "Credentials", "PositiveClientPassword");

    String Edrpou = excelFile.exportFromExcelFile("Credentials", "SmokeTestData", "Edrpou");

    System.out.println("Eerpou = " + Edrpou);

    String countsIA = excelFile.exportFromExcelFile("Credentials", "SmokeTestData", "CountsIA");

    System.out.println("Count of personal accounts = "+ countsIA);

    String responsiblePerson = excelFile.exportFromExcelFile("Credentials", "SmokeTestData", "responsiblePerson");

    String companyAddress = excelFile.exportFromExcelFile("Credentials", "SmokeTestData", "CompanyAddress");

    String bankAccount = excelFile.exportFromExcelFile("Credentials", "SmokeTestData", "BankAccount");

    String bankName = excelFile.exportFromExcelFile("Credentials", "SmokeTestData", "BankName");

    String adminEmail = excelFile.exportFromExcelFile("Credentials", "Credentials", "AdminEmail");

    String adminPassword = excelFile.exportFromExcelFile("Credentials", "Credentials","AdminPassword");

    MainPage.openPage(host);

    MainPage.login(Email, Password);

    //DashPage.assistanceClose();

    DashPage.goToContract();

    ThreeStepsPage.fillEdrpou(Edrpou);

    ThreeStepsPage.fillAccountCounts(countsIA);

    ThreeStepsPage.fillresponsiblePerson(responsiblePerson);

    ThreeStepsPage.fillCompanyAddress(companyAddress);

    ThreeStepsPage.fillBankAccount(bankAccount);

    ThreeStepsPage.fillBankName(bankName);

    ThreeStepsPage.fillDataOfContract();

    ThreeStepsPage.pressConfirmBtn();

    ThreeStepsPage.contractDownload();

    ThreeStepsPage.exitAccount();

    MainPage.loginOnLoginPage(adminEmail, adminPassword);

    controlManagerPage.companyNameFilter("Smoke Test");

    controlManagerPage.activateCompany();

    }

}
