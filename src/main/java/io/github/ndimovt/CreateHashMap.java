package io.github.ndimovt;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import io.github.ndimovt.mongoutilitypackage.DBConnection;

import java.util.HashMap;
public class CreateHashMap {
    public HashMap<String, Double> populateMap(int year) {
        HashMap<String, Double> agricultureProductRecords = new HashMap<String,Double>();
        BasicDBObject querry = new BasicDBObject("year",year);
        DBCursor cursor = DBConnection.getCollection().find(querry);
        while (cursor.hasNext()){
            DBObject nextObject = cursor.next();
            String fieldName = (String) nextObject.get("product_name");
            double fieldValue = (double) nextObject.get("product_price");
            agricultureProductRecords.put(fieldName,fieldValue);
        }
        return agricultureProductRecords;
    }
}
