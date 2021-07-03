package ua.com.miydimonline.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.com.miydimonline.Utils.WebDriverUtil;

import java.util.List;

public class MiyDimOnlineSettlementPeriodsPage {

    private By tableLocator = By.xpath(".//div[@class='dx-datagrid-rowsview dx-last-row-border']//tbody");
    private By closeStatusLocator = By.xpath(".//td[text()='Закритий']");

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public MiyDimOnlineSettlementPeriodsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void closeSettlementPeriod(String mounth){


        WebDriverWait customWait = new WebDriverWait(webDriver,360);

        WebElement table = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tableLocator));

        List<WebElement> dataRows = table.findElements(By.tagName("tr"));

        Boolean isPeriodClose = false;

        if (dataRows.size() != 0){

            System.out.println("Counts of rows = " + dataRows.size());

            for(int i=0; i<dataRows.size(); i++){

                List<WebElement> dataCols = dataRows.get(i).findElements(By.tagName("td"));

                System.out.println("Counts of cols = " + dataCols.size());

                for(int j=0; j<dataCols.size(); j++){

                    if(mounth.equals(dataCols.get(j).getText())){

                        WebElement periodSwitchOn = dataRows.get(i).findElement(By.xpath(".//div[@class='dx-switch-on']"));

                        periodSwitchOn.click();

                        System.out.println("Switch click");

                        //By closeStatusLocator = (By) dataRows.get(i).findElement(By.xpath(".//td[text()='Закритий']"));

                        WebElement periodStatus = customWait.until(ExpectedConditions.presenceOfElementLocated(closeStatusLocator));

                        isPeriodClose = true;

                        break;
                    }

                }

                if (isPeriodClose == true){

                    break;

                }
            }

        }

    }
}
