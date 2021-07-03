package ua.com.miydimonline;


import org.junit.runners.Suite;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ua.com.miydimonline.Core.TestListener;
import ua.com.miydimonline.Core.WebDriverTestBase;
import ua.com.miydimonline.Pages.*;
import ua.com.miydimonline.Utils.WorkWithExcelFile;

import java.util.function.Function;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class SmokeTests extends WebDriverTestBase {


    @Test(priority=1)
    public void openRegistrationList() {

        MiyDimOnlineMainPage MainPage = new MiyDimOnlineMainPage(webdriver);

        MiyDimOnlineDashboardPage DashPage = new MiyDimOnlineDashboardPage(webdriver);

        MiyDimOnlineRegistrationThreeStepsPage ThreeStepsPage = new MiyDimOnlineRegistrationThreeStepsPage(webdriver);

        MiyDimOnlineControlManagerPage controlManagerPage = new MiyDimOnlineControlManagerPage(webdriver);

        MiyDimOnlineAdminHeaderMenu AdminHeaderMenuPage = new MiyDimOnlineAdminHeaderMenu(webdriver);

        WorkWithExcelFile excelFile = new WorkWithExcelFile();

        //----------------------------------------------------------------------------------------------------------------------------------
        // Export data from excel file

        // Test company login
        String Email = excelFile.exportFromExcelFile("Credentials","Credentials", "EmailForSmokeTest");

        // Test company Password
        String Password = excelFile.exportFromExcelFile("Credentials", "Credentials", "PositiveClientPassword");

        // Test company EDRPOU
        String Edrpou = excelFile.exportFromExcelFile("Credentials", "SmokeTestData", "Edrpou");

        System.out.println("Eerpou = " + Edrpou);

        // Count of personal account
        String countsIA = excelFile.exportFromExcelFile("Credentials", "SmokeTestData", "CountsIA");

        System.out.println("Count of personal accounts = "+ countsIA);

        // FIO of director
        String responsiblePerson = excelFile.exportFromExcelFile("Credentials", "SmokeTestData", "responsiblePerson");

        // Test Company Address
        String companyAddress = excelFile.exportFromExcelFile("Credentials", "SmokeTestData", "CompanyAddress");

        // Test Company bank account number
        String bankAccount = excelFile.exportFromExcelFile("Credentials", "SmokeTestData", "BankAccount");

        // Test Company bank name
        String bankName = excelFile.exportFromExcelFile("Credentials", "SmokeTestData", "BankName");

        // Test Company admin email
        String adminEmail = excelFile.exportFromExcelFile("Credentials", "Credentials", "AdminEmail");
        // Test Company admin password
        String adminPassword = excelFile.exportFromExcelFile("Credentials", "Credentials","AdminPassword");

        //------------------------------------------------------------------------------------------------------------------------------------

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

        AdminHeaderMenuPage.logOut();

    }

    @Test(priority=2)
    public void SmokeTest1() throws InterruptedException {

        MiyDimOnlineMainPage MainPage = new MiyDimOnlineMainPage(webdriver);

        MiyDimOnlineManagerSideMenu ManagerSideMenu = new MiyDimOnlineManagerSideMenu(webdriver);

        MiyDimOnlineAccuralItemPage AccrualItemPage = new MiyDimOnlineAccuralItemPage(webdriver);

        MiyDimOnlineAccrualCreatePage AccrualCreatePage = new MiyDimOnlineAccrualCreatePage(webdriver);

        MiyDimOnlineAccrualTariffsPage AccrualTariffPage = new MiyDimOnlineAccrualTariffsPage(webdriver);

        MiyDimOnlineBuildingsObjectsPage BuildingsObjectsPage = new MiyDimOnlineBuildingsObjectsPage(webdriver);

        MiyDimOnlineFlatsPage FlatsPage = new MiyDimOnlineFlatsPage(webdriver);

        MiyDimOnlineAccrualConnectionPage accrualConnectionPage = new MiyDimOnlineAccrualConnectionPage(webdriver);

        MiyDimOnlineAccrualCreateConnectionPage AccrualCreateConnectionPage = new MiyDimOnlineAccrualCreateConnectionPage(webdriver);

        MiyDimOnlineSettlementPeriodsPage settlementPeriodsPage = new MiyDimOnlineSettlementPeriodsPage(webdriver);

        MiyDimOnlineJournalOfOperationsPage journalOfOperationsPage = new MiyDimOnlineJournalOfOperationsPage(webdriver);

        MiyDimOnlineReceiptPage receiptPage = new MiyDimOnlineReceiptPage(webdriver);

        WorkWithExcelFile ExcelFile = new WorkWithExcelFile();

        String Email = ExcelFile.exportFromExcelFile("Credentials", "Credentials", "EmailForSmokeTest");

        String Password = ExcelFile.exportFromExcelFile("Credentials", "Credentials","PositiveClientPassword");

        MainPage.openPage(host);

        MainPage.login(Email, Password);

        ManagerSideMenu.toAccurualItem();

        AccrualItemPage.createAccuralItem();

        AccrualCreatePage.addHousekeepingAccurualItem();

        AccrualTariffPage.editTarifs();

        String tariffStartData = ExcelFile.exportFromExcelFile("Credentials", "SmokeTestData", "TariffStartData");

        String tariffValue = ExcelFile.exportFromExcelFile("Credentials", "SmokeTestData", "TariffValue");

        AccrualTariffPage.addTariff(tariffStartData,tariffValue);

        ManagerSideMenu.toBuildingObjects();

        BuildingsObjectsPage.createApartmentHouse("Київ", "м. Київ", "Київ", "Новогоспітальна", "вул. Новогоспітальна");

        FlatsPage.editMode();

        FlatsPage.addSinglePersonalAccount("5002", "2");

        FlatsPage.saveData();

        FlatsPage.toAccrualConnectionPage();

        accrualConnectionPage.addAccrualConnection();

        AccrualCreateConnectionPage.EditMode();

        AccrualCreateConnectionPage.addAccrualConnection("5002", "01.03.2021", "100", "64.11" );

        AccrualCreateConnectionPage.saveConnection();

        ManagerSideMenu.toSettlementPeriods();

        settlementPeriodsPage.closeSettlementPeriod("Березень");

        ManagerSideMenu.toJournalOfOperations();

        journalOfOperationsPage.goToReceipt("03", "2021");

        String personalNumber = receiptPage.getPersonalNumber();

        assertEquals("Особовий рахунок 5002", personalNumber);

        String companyName = receiptPage.getCompanyName();

        companyName = companyName.replace(" код ЄДРПОУ","");

        System.out.println(companyName);

        assertEquals("Smoke Test", companyName);

        String residentAddress = receiptPage.getResidentAddress();

        assertEquals("м. Київ, вул. Новогоспітальна, 5, кв. 2;", residentAddress);

        receiptPage.getAccrualName("Утримання будинку");



    }
}
