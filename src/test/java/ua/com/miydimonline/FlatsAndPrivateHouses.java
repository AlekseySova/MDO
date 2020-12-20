package ua.com.miydimonline;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ua.com.miydimonline.Core.TestListener;
import ua.com.miydimonline.Core.WebDriverTestBase;
import ua.com.miydimonline.Pages.MiyDimOnlineBuildingsObjectsPage;
import ua.com.miydimonline.Pages.MiyDimOnlineDashboardPage;
import ua.com.miydimonline.Pages.MiyDimOnlineFlatsPage;
import ua.com.miydimonline.Pages.MiyDimOnlineMainPage;
import ua.com.miydimonline.Utils.WorkWithExcelFile;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class FlatsAndPrivateHouses extends WebDriverTestBase {

    @Epic("Об'екты недвижимости")
    @Feature("Miydimonline")
    @Story("Flats and personal accounts")
    @Test(priority = 1,description = "MDOFLAT0001")
    public void newFlat1(){

        MiyDimOnlineMainPage MainPage = new MiyDimOnlineMainPage(webdriver);

        MiyDimOnlineDashboardPage DashPage = new MiyDimOnlineDashboardPage(webdriver);

        MiyDimOnlineBuildingsObjectsPage BuildingObjectsPage = new MiyDimOnlineBuildingsObjectsPage(webdriver);

        MiyDimOnlineFlatsPage FlatsPage = new MiyDimOnlineFlatsPage(webdriver);

        MainPage.openPage(host);

        WorkWithExcelFile excelFile = new WorkWithExcelFile();

        String clientLogin = excelFile.exportFromExcelFile("Credentials","PositiveClientLogin");

        MainPage.openPage(host);

        String clientPassword = excelFile.exportFromExcelFile("Credentials","PositiveClientPassword");

        MainPage.login(clientLogin, clientPassword);

        DashPage.goToBuildingObjects();

        BuildingObjectsPage.goToFlats("Леніна");

        String lastFlatNumber = FlatsPage.flatAndPCountData();

        FlatsPage.editMode();

        FlatsPage.addFlat();

        FlatsPage.saveData();

        String newFlatNumber = FlatsPage.flatAndPCountData();

        int lastFlatNumberInt = Integer.parseInt(lastFlatNumber);

        int newFlatNumberInt = Integer.parseInt(newFlatNumber);

        assertEquals(lastFlatNumberInt + 1, newFlatNumberInt);
    }
    @Epic("Об'екты недвижимости")
    @Feature("Miydimonline")
    @Story("Flats and personal accounts")
    @Test(priority = 1,description = "MDOFLAT0002")
    public void addPersonalAccount(){



    }


}
