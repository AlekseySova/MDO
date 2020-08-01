package ua.com.miydimonline.Utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.io.File;

import static com.google.common.io.Files.toByteArray;

public class WebDriverUtil {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    long explicitWait = Long.parseLong(PropertiesCache.getProperty("wait.explicit"));

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

    public void focusElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;

        String javaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); " +
                "mouseEventObj.initEvent( 'mouseover', true, true ); " +
                "element.dispatchEvent(mouseEventObj);";

        js.executeScript(javaScript, element);
    }

}
