package ua.com.miydimonline;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import ua.com.miydimonline.Core.TestListener;
import ua.com.miydimonline.Core.WebDriverTestBase;
import ua.com.miydimonline.Pages.MiyDimOnlineDashboardPage;
import ua.com.miydimonline.Pages.MiyDimOnlineMainPage;
import ua.com.miydimonline.Utils.WorkWithExcelFile;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class Login extends WebDriverTestBase {

    String expectedText = "Сова 10005";
    String expectedValidMassege = "Будь ласка, введіть коректну електронну адресу і пароль облікового запису";

    @Epic("Регистрация компании")
    @Feature("Miydimonline")
    @Story("Login")
    @Test(priority = 1,description = "Login")
    public void validLogin(){
        MiyDimOnlineMainPage MainPage = new MiyDimOnlineMainPage(webdriver);

        MiyDimOnlineDashboardPage DashboardPage = new MiyDimOnlineDashboardPage(webdriver);

        WorkWithExcelFile excelFile = new WorkWithExcelFile();

        String clientLogin = excelFile.exportFromExcelFile("Credentials","PositiveClientLogin");

        MainPage.openPage(host);

        String clientPassword = excelFile.exportFromExcelFile("Credentials","PositiveClientPassword");

        MainPage.login(clientLogin, clientPassword);

        String clientName = DashboardPage.clientConfirm();

        assertEquals(clientName, expectedText);

        DashboardPage.accountExit();

    }
    @Epic("Регистрация компании")
    @Feature("Miydimonline")
    @Test(priority = 2, description = "MDOLOG0002")
    public void unValidLogin(){

        MiyDimOnlineMainPage MainPage = new MiyDimOnlineMainPage(webdriver);

        MainPage.openPage(host);
        MainPage.login("citigacy+company10005@gmail.com", "Testtest@48");

        String validMessage = MainPage.unValideLoginConfirm();

        assertEquals(expectedValidMassege, validMessage);
    }
    @Epic("Регистрация компании")
    @Feature("Miydimonline")
    @Test(priority = 2, description = "MDOLOG0003")
    public void loginWithOutEmail(){

        MiyDimOnlineMainPage MainPage = new MiyDimOnlineMainPage(webdriver);

        WorkWithExcelFile excelFile = new WorkWithExcelFile();

        String clientPassword = excelFile.exportFromExcelFile("Credentials","PositiveClientPassword");

        String expectedResult = excelFile.exportFromExcelFile("Credentials","EmptyEmailValidation");

        MainPage.openPage(host);

        MainPage.login("", clientPassword);

        String emptyEmailMessage = MainPage.emptyEmailValidation();

        assertEquals(expectedResult,emptyEmailMessage);


    }

}
