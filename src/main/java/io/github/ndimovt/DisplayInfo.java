package io.github.ndimovt;

import java.util.HashMap;
import java.util.Map;

public class DisplayInfo {
    public void displayInfoForParticularYear(int year){
        CreateHashMap chm = new CreateHashMap();
        HashMap<String, Double>  agricultureData = chm.populateMap(year);
        for(Map.Entry<String, Double> products : agricultureData.entrySet()){
            System.out.println(products.getKey() +" / "+ products.getValue());
        }
    }
}
