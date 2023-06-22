package io.github.ndimovt;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.HashMap;
import java.util.Map;

public class InfoMap {
    private Map<String, Double> agriInfo = new HashMap<String,Double>();
    {
        DBObject query = new BasicDBObject();
        DBCursor cursor = new DBConnection().getCollection().find(query);
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
