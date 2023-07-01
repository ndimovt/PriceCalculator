package io.github.ndimovt;

import MongoUtilityPackage.MongoDBOperations;

public class DBWriting {
    protected void addProductToDB(String productName, double productPrice, int option){
        MongoDBOperations mdbo = new MongoDBOperations();
        AgricultureProduct product = new AgricultureProduct(productName, productPrice);
        CreateDBObject createDBObject = new CreateDBObject();
        mdbo.getCollection(option).insert(createDBObject.createProduct(product));
    }


}
