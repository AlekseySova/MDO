package ua.com.miydimonline.Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class WorkWithExcelFile {

    //String filePath = "C:\\Users\\citig\\IdeaProjects\\MiyDimOnline-Selenium-Java\\src\\main\\resources\\Credentials.xlsx";

    public String exportFromExcelFile(String sheetName,String variableName){

        String valueString = null;

        try{
            String path = new File("src\\main\\resources").getAbsolutePath();

            FileInputStream file = new FileInputStream(path +"\\Credentials.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet(sheetName);

            Iterator<Row> rowIterator = sheet.iterator();

            Boolean ifVariableTrue = false;

            while(rowIterator.hasNext()){

                Row row = rowIterator.next();

                Cell keyCell = row.getCell(0);

                //System.out.println("keyCell = " + keyCell);
                //System.out.println("variableName = " + variableName);


                if (variableName.equals(keyCell.toString())){

                    valueString = row.getCell(1).toString();
                    //System.out.println("valueCell = " + valueString);
                    ifVariableTrue = true;
                }

                file.close();
            }
            if(ifVariableTrue == false){

                System.out.println("Variable not found in file");

            }


        }catch (Exception e) {

            e.printStackTrace();
        }
        return valueString;
    }

}
