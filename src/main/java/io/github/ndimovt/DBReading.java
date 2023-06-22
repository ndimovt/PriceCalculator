package io.github.ndimovt;

import java.util.Map;

public class DBReading {
    private InfoMap infoMap = new InfoMap();

    public void showFullInfo(){
        Map<String, Double> agricultureData = infoMap.getAgriInfo();
        for(Map.Entry<String, Double> products : agricultureData.entrySet()){
            System.out.println(products.getKey() +" / "+ products.getValue());
        }
    }
}
