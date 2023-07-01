package io.github.ndimovt;

import MongoUtilityPackage.MongoDBOperations;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InfoMap {
    Scanner inn = new Scanner(System.in);
    private Map<String, Double> agriInfo = new HashMap<String,Double>();

    {
        System.out.println("Enter year to get information.");
        int year = inn.nextInt();
        //DBObject query = new BasicDBObject();
        MongoDBOperations mdbo = new MongoDBOperations();
        DBCursor cursor = mdbo.getCollection(year).find(new BasicDBObject());
        while (cursor.hasNext()){
            DBObject nextObject = cursor.next();
            String fieldName = (String) nextObject.get("Product");
            double fieldValue = (double) nextObject.get("Price per Ton");
            agriInfo.put(fieldName,fieldValue);
        }
    }

    public Map<String, Double> getAgriInfo() {
        return agriInfo;
    }

}
