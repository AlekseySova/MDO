package ua.com.miydimonline;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ua.com.miydimonline.Core.TestListener;
import ua.com.miydimonline.Core.WebDriverTestBase;
import ua.com.miydimonline.Pages.MiyDimOnlineMainPage;

@Listeners({TestListener.class})
public class CompanyRegistration extends WebDriverTestBase {

    String site = "https://osbb-uat.dynamo-ny.com";

    @Test
    public void openRegistrationList() {

    MiyDimOnlineMainPage MainPage = new MiyDimOnlineMainPage(webdriver);

    MainPage.openPage(site);

    MainPage.companyRegButton();

    }

}
