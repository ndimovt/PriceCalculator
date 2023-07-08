package io.github.ndimovt;

import MongoUtilityPackage.DBConnectionAndCreateCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class DBWriting {

    public void addProductToDB(String productName, double productPrice, int option){
        AgricultureProduct product = new AgricultureProduct(productName, productPrice);
        DBConnectionAndCreateCollection.getCollection(option).insert(createProduct(product));
    }
    private DBObject createProduct(AgricultureProduct agricultureProduct){
        return new BasicDBObject("Product",agricultureProduct.getProductName()).append("Price per Ton",agricultureProduct.getProductPrice());
    }


}
