package io.github.ndimovt;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import io.github.ndimovt.mongoutilitypackage.DBConnection;

public class DBWriting {
    public void addProductToDB(int year,String productName, double productPrice){
        AgricultureProduct agricultureProduct = new AgricultureProduct(year,productName,productPrice);
        DBConnection.getCollection().insert(createProduct(agricultureProduct));
    }
    private DBObject createProduct(AgricultureProduct agricultureProduct){
        return new BasicDBObject("year",agricultureProduct.getYear()).append("product_name",agricultureProduct.getProductName()).
                append("product_price",agricultureProduct.getProductPrice());
    }
}
