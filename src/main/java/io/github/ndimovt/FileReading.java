package io.github.ndimovt;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileReading {
    private Map<String, String> readInformation(String year) {
        Map<String, String> agricultureInfo = new HashMap<>();
        try {
            FileInputStream fileReader = new FileInputStream("C:\\Users\\Nikolai\\Desktop\\Prices.xlsx");
            Workbook readInfo = new XSSFWorkbook(fileReader);
            Sheet sheet = readInfo.getSheet(year);
            for(Row row: sheet){
                Cell keyCell = row.getCell(0);
                Cell valueCell = row.getCell(1);
                if((keyCell != null) && (valueCell != null)){
                    String key = keyCell.toString();
                    String value = valueCell.toString();
                    agricultureInfo.put(key,value);
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
    public void getSpecificAgricultureInfo(String year, String agricultureProduct){
        for(Map.Entry<String,String> specificProductInfo : readInformation(year).entrySet()){
            if(specificProductInfo.getKey().contains(agricultureProduct)){
                System.out.println(specificProductInfo.getKey()+" : "+specificProductInfo.getValue());
            }
        }
    }
    public void getEntireAgricultureProductInfo(String year){
        for(Map.Entry<String, String> allProductsInfo : readInformation(year).entrySet()){
            System.out.println(allProductsInfo.getKey()+" : "+allProductsInfo.getValue());
        }
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
