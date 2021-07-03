package ua.com.miydimonline;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ua.com.miydimonline.Core.TestListener;
import ua.com.miydimonline.Core.WebDriverTestBase;
import ua.com.miydimonline.Pages.MiyDimOnlineDashboardPage;
import ua.com.miydimonline.Pages.MiyDimOnlineMainPage;
import ua.com.miydimonline.Utils.WorkWithExcelFile;

@Listeners({TestListener.class})
public class BuildingObjects extends WebDriverTestBase {

    @Test
    public void addMultipleFlat (){

    MiyDimOnlineMainPage MainPage = new MiyDimOnlineMainPage(webdriver);

    MainPage.openPage(host);

    WorkWithExcelFile excelFile = new WorkWithExcelFile();

    String clientLogin;

    //MainPage.login();


    }

}
