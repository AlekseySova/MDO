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

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class Test1Login extends WebDriverTestBase {

    String WebSite = "https://osbb-uat.dynamo-ny.com";
    String expectedText = "Сова9310";
    String expectedValidMassege = "Будь ласка, введіть коректну електронну адресу і пароль облікового запису";

    @Epic("Регистрация компании")
    @Feature("Miydimonline")
    @Story("Login")
    @Test(priority = 1,description = "Login")
    public void validLogin(){
        MiyDimOnlineMainPage MainPage = new MiyDimOnlineMainPage(webdriver);

        MiyDimOnlineDashboardPage DashboardPage = new MiyDimOnlineDashboardPage(webdriver);

        MainPage.openPage(WebSite);

        MainPage.login("citigacy+company9310@gmail.com", "Testtest@47");

        String clientName = DashboardPage.clientConfirm();

        assertEquals(expectedText, clientName);

    }
    @Epic("Регистрация компании")
    @Test
    public void unValidLogin(){

        MiyDimOnlineMainPage MainPage = new MiyDimOnlineMainPage(webdriver);

        MainPage.openPage(WebSite);
        MainPage.login("citigacy+company9310@gmail.com", "Testtest@48");

        String validMessage = MainPage.unValideLoginConfirm();

        assertEquals(expectedValidMassege, validMessage);
    }
}
