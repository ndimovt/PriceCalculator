package io.github.ndimovt;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataStructure {
    private Map<String, Double> agricultureProductsAndPrices;
    private Map<String, Double> putInfoInDataStructure(String year) {
        Map<String, Double> agricultureInfo = new HashMap<>();
        try {
            FileInputStream fileReader = new FileInputStream("C:\\Users\\Nikolai\\Desktop\\Prices.xlsx");
            Workbook readInfo = new XSSFWorkbook(fileReader);
            Sheet sheet = readInfo.getSheet(year);
            for(Row row: sheet){
                Cell keyCell = row.getCell(0);
                Cell valueCell = row.getCell(1);
                if((keyCell != null) && (valueCell != null)){
                    String key = keyCell.toString();
                    Double pValue = Double.parseDouble(valueCell.toString());
                    agricultureInfo.put(key,pValue);
                }
            }
            closingStreams(readInfo,fileReader);
        } catch (FileNotFoundException fnf) {
            System.out.println("Missing file!");
            fnf.printStackTrace();
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return agricultureInfo;
    }
    public Map<String, Double> productAndPriceList(String year){
        return agricultureProductsAndPrices = putInfoInDataStructure(year);
    }
    private void closingStreams( Workbook workbook, FileInputStream fileInputStream) throws IOException{
        if(workbook != null){
            workbook.close();
        }
        if(fileInputStream != null){
            fileInputStream.close();
        }
    }
}
