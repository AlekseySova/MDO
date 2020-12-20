package ua.com.miydimonline.Pages;

import com.gargoylesoftware.htmlunit.javascript.host.canvas.ext.WEBGL_compressed_texture_s3tc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

import java.util.List;

public class MiyDimOnlineFlatsPage {

    private By editButtonLocator = By.xpath(".//div[@aria-label='Редагувати']");
    private By addButtonLocator = By.xpath(".//button[@type='button']//i[@class='mi mi-form-add svg-inline-it']");
    private By addFlatButtonLocator = By.xpath(".//div[@class='dx-item-content dx-menu-item-content']//span[@class='dx-menu-item-text' and text()='Додати квартиру']");
    private By flatsRowLocator = By.xpath(".//tbody[@role='presentation']//tr[@aria-rowindex]");
    private By saveButtonLocator = By.xpath(".//div[@class='dx-button-content']//span[@class='dx-button-text' and text()='Зберегти']");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineFlatsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void editMode(){

        WebElement editButton = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(editButtonLocator));

        editButton.click();
    }

    public void addFlat(){

        WebElement addButton = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(addButtonLocator));

        addButton.click();

        WebElement addFlatButton = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(addFlatButtonLocator));

        addFlatButton.click();

        
    }

    public String flatAndPCountData(){

    List<WebElement> flatsRow = webDriverUtil.waitForExpectedConList(ExpectedConditions.presenceOfAllElementsLocatedBy(flatsRowLocator));

    int lastFlatRow = 0;
        if (flatsRow != null && !flatsRow.isEmpty()) {
            lastFlatRow = flatsRow.size();
        }
    System.out.println("Last flat of table = " + lastFlatRow);

    WebElement lastFlat = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(By.xpath(".//tr[@aria-rowindex='"+lastFlatRow+"']//td[@aria-colindex='2']//a")));

    String lastflatNumber = lastFlat.getAttribute("innerHTML");

    System.out.println("Last number of flat = " + lastflatNumber);

    return lastflatNumber;

    }

    public void saveData(){

        WebElement saveButton = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(saveButtonLocator));

        saveButton.click();

    }

}
