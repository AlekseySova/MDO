package ua.com.miydimonline.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class FindCellInTable {

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    public FindCellInTable(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public ArrayList<Integer> getCellPositionFromTable(By tableLocator,String tagName, String cellText){

        Boolean isColFind = false;

        ArrayList colPosition = new ArrayList();

        WebElement table = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tableLocator));

        List<WebElement> tableRows = table.findElements(By.tagName("tr"));

        for (int i=0 ; i<tableRows.size(); i++){

            List<WebElement> tableCols = tableRows.get(i).findElements(By.tagName(tagName));

            for (int j=0; j<tableCols.size(); j++){

                if (cellText.equals(tableCols.get(j).getText())){

                    colPosition.add(i);
                    colPosition.add(j);

                    isColFind = true;

                    break;
                }

            }

            if(isColFind == true){

                break;

            }


        }

        return colPosition;

    }

    public WebElement getCellDataFromReceipt(By tableLocator,int rowIndex,int colIndex, String colTagName){

        Boolean isColFind = false;

        WebElement cellElement = null;

        WebElement table = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tableLocator));

        List<WebElement> tableRows = table.findElements(By.tagName("tr"));

        for (int i=0 ; i<tableRows.size(); i++){

            List<WebElement> tableCols = tableRows.get(i).findElements(By.tagName(colTagName));

            for (int j=0; j<tableCols.size(); j++){

                if (rowIndex == i && colIndex == j){

                    cellElement = tableCols.get(j);

                    isColFind = true;

                    break;
                }

            }

            if(isColFind == true){

                break;

            }


        }

        return cellElement;
    }


    public List<WebElement> getTableDataRowFromCellData(By tableLocator,String cellText, String tagName){

        Boolean isColFind = false;

        List<WebElement> rowData = null;

        WebElement table = webDriverUtil.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(tableLocator));

        List<WebElement> tableRows = table.findElements(By.tagName("tr"));

        for (int i=0 ; i<tableRows.size(); i++){

            List<WebElement> tableCols = tableRows.get(i).findElements(By.tagName(tagName));

            for (int j=0; j<tableCols.size(); j++){

                if (cellText.equals(tableCols.get(j).getText())){

                    rowData= tableCols;

                    isColFind = true;

                    break;
                }

            }

            if(isColFind == true){

                break;

            }


        }

        return rowData;
    }

}
