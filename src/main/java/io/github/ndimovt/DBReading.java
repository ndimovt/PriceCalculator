package io.github.ndimovt;

import java.sql.SQLOutput;
import java.util.Map;
public class DBReading {
    private DataStructure dataStructure = new DataStructure();
    public void getSpecificAgricultureInfo(String year, String agricultureProduct){
        for(Map.Entry<String,Double> specificProductInfo : dataStructure.productAndPriceList(year).entrySet()){
            if(specificProductInfo.getKey().contains(agricultureProduct)){
                System.out.println(specificProductInfo.getValue() + " USD per ton.");
            }
        }
    }
    public void getEntireAgricultureProductInfo(String year){
        System.out.println("Product | Price (USD per ton)");
        System.out.println("____________________________");
        for(Map.Entry<String, Double> allProductsInfo : dataStructure.productAndPriceList(year).entrySet()){
            System.out.println(allProductsInfo.getKey()+" : "+allProductsInfo.getValue());
        }
    }
}
