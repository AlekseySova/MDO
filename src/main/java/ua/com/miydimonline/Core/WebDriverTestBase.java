package ua.com.miydimonline.Core;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import ua.com.miydimonline.Utils.PropertiesCache;

import java.util.concurrent.TimeUnit;

@Listeners({})
public class WebDriverTestBase {

    protected WebDriver webdriver;

    private String browser = System.getProperty("browser");
    long implicitWait = Long.parseLong(PropertiesCache.getProperty("wait.implicit"));
    long pageLoadTimeout = Long.parseLong(PropertiesCache.getProperty("wait.pageload"));
    long setScriptTimeout = Long.parseLong(PropertiesCache.getProperty("wait.setscript"));
    public String host = "https://osbb-uat.dynamo-ny.com/";

    @BeforeClass

    public void stepUp(){
        // manual version
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\citig\\IdeaProjects\\MiyDimOnline-Selenium-Java\\src\\main\\resources\\chromedriver84.exe");
        webdriver = new ChromeDriver();

        setWebDriverSettings();

    }

    public void setWebDriverSettings(){

        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        webdriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout,TimeUnit.SECONDS);
        webdriver.manage().timeouts().setScriptTimeout(setScriptTimeout,TimeUnit.SECONDS);

    }


    @AfterClass

    public void testDown(){

        //webdriver.quit();

    }

}
