package ua.com.miydimonline.Utils;

import io.qameta.allure.Attachment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.poi.hssf.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.google.common.io.Files.toByteArray;

public class WebDriverUtil {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    long explicitWait = Long.parseLong(PropertiesCache.getProperty("wait.explicit"));
    //String filePath = "..IdeaProjects\\MiyDimOnline-Selenium-Java\\src\\main\\resources\\Credentials.xlsx";

    public WebDriverUtil(WebDriver webDriver){

        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, explicitWait);

    }

    public WebElement waitForExpectedCondition(ExpectedCondition expectedCondition) {
        return  (WebElement)webDriverWait.until(expectedCondition);
    }

    public List<WebElement> waitForExpectedConList(ExpectedCondition expectedCondition){

        return (List<WebElement>)webDriverWait.until(expectedCondition);
    }

    @Attachment( value = "{0}")
    public byte[] saveScreenshot(String attachName){

        try{

            File scrFile =((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            return toByteArray(scrFile);
        }catch (Exception e) {
            System.out.println("Is not saved screenshot" + e);
        }

        return new byte[0];
    }

    public void switchToNewTab (String oldTab){

        ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(newTab.get(1));

    }
}
