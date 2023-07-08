package io.github.ndimovt;

import MongoUtilityPackage.DBConnectionAndCreateCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ReadShowCalculate {
    private DecimalFormat df = new DecimalFormat("0.00");
    protected HashMap<String, Double> getAgriInfo(int year) {
        HashMap<String, Double> agriInfo = new HashMap<String,Double>();
        DBCursor cursor = DBConnectionAndCreateCollection.getCollection(year).find(new BasicDBObject());
        while (cursor.hasNext()){
            DBObject nextObject = cursor.next();
            String fieldName = (String) nextObject.get("Product");
            double fieldValue = (double) nextObject.get("Price per Ton");
            agriInfo.put(fieldName,fieldValue);
        }
        return agriInfo;
    }

    public void showInfo(int year){
        HashMap<String, Double>  agricultureData = getAgriInfo(year);
        for(Map.Entry<String, Double> products : agricultureData.entrySet()){
            System.out.println(products.getKey() +" / "+ products.getValue());
        }
    }
    public double calculateProfit(int year, String agriProductName, double productQuantity) throws NullPointerException{
        Map<String, Double> af = getAgriInfo(year);
        double value = af.get(agriProductName);
        String profit = df.format(value*productQuantity);
        return Double.parseDouble(profit);
    }
}
