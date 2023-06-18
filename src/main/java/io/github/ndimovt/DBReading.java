package io.github.ndimovt;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.HashMap;
import java.util.Map;

public class DBReading {
    protected Map<String, Double> agricultureInfo(){
        Map<String, Double> info = new HashMap<>();
        DBObject query = new BasicDBObject();
        DBCursor cursor = new DBConnection().getCollection().find(query);
        while (cursor.hasNext()){
            DBObject nextObject = cursor.next();
            String fieldName = (String) nextObject.get("Product");
            double fieldValue = (double) nextObject.get("Price per Ton");
            info.put(fieldName,fieldValue);
        }
        return info;
    }
    public void showFullInfo(){
        Map<String, Double> agricultureData = agricultureInfo();
        for(Map.Entry<String, Double> products : agricultureData.entrySet()){
            System.out.println(products.getKey() +" / "+ products.getValue());
        }
    }
}
