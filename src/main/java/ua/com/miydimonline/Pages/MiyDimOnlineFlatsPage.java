package ua.com.miydimonline.Pages;

import com.gargoylesoftware.htmlunit.javascript.host.canvas.ext.WEBGL_compressed_texture_s3tc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.miydimonline.Utils.WebDriverUtil;

import java.awt.*;
import java.util.List;

public class MiyDimOnlineFlatsPage {

    private By editButtonLocator = By.xpath(".//div[@aria-label='Редагувати']");
    private By addButtonLocator = By.xpath(".//button[@type='button']//i[@class='mi mi-form-add svg-inline-it']");
    private By addFlatButtonLocator = By.xpath(".//div[@class='dx-item-content dx-menu-item-content']//span[@class='dx-menu-item-text' and text()='Додати квартиру']");
    private By flatsRowLocator = By.xpath(".//tbody[@role='presentation']//tr[@aria-rowindex]");
    private By saveButtonLocator = By.xpath(".//div[@class='dx-button-content']//span[@class='dx-button-text' and text()='Зберегти']");
    private By tableLocator = By.xpath(".//*[@class='dx-datagrid-rowsview dx-datagrid-nowrap dx-scrollable dx-visibility-change-handler dx-scrollable-both dx-scrollable-simulated dx-scrollable-customizable-scrollbars']//tbody");
    private By headerPAColLocator = By.xpath(".//*[@class='dx-datagrid-headers dx-datagrid-nowrap dx-header-multi-row']//td[@aria-label='Столбец Особовий рахунок']");
    private By tableInputLocator = By.xpath(".//input[@tabindex='0']");
    private By accrualConnectionMenuItemLocator = By.xpath(".//ul[@class='main-nav-tabs']//a[contains(@href,'/uk/tariffs/tarifflistforbuildingitemgroup')]//parent::li");

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

        WebElement editButton = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(editButtonLocator));

    }

    public void addSinglePersonalAccount(String personalNumber, String flatNumber){

        WebElement personalAccountHeader = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(headerPAColLocator));

        String pAcolumnIndex = personalAccountHeader.getAttribute("aria-colindex");



    WebElement flatTable = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tableLocator));

    List<WebElement> tableRows = flatTable.findElements(By.tagName("tr"));

    int row_count = tableRows.size();

    System.out.println("Rows in table = "+row_count);

    for (int row=0; row < row_count; row++ ){

        List<WebElement> rowColumn = tableRows.get(row).findElements(By.tagName("td"));

        int col_count = rowColumn.size();

        System.out.println("Column in row = "+col_count);

        String flatNumberStr = rowColumn.get(3).getText();

        System.out.println("Flat number = "+flatNumberStr);

        if(flatNumberStr.equals(flatNumber)){

            System.out.println("Correct number = "+flatNumberStr );

                rowColumn.get(Integer.parseInt(pAcolumnIndex)-1).click();

                /*
                Robot robot = null;
                try {
                    robot = new Robot();
                } catch (AWTException e) {
                    e.printStackTrace();
                }
                robot.delay(1000); // 1 SECOND

                 */
                WebElement pAInput = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tableInputLocator));

                pAInput.sendKeys(personalNumber + Keys.ENTER);

                break;

                }

        }

    }

    public void toAccrualConnectionPage(){

        WebElement accrualConnectionMenuItem = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(accrualConnectionMenuItemLocator));

        accrualConnectionMenuItem.click();
    }

}
