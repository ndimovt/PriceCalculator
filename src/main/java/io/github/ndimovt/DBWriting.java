package io.github.ndimovt;

public class DBWriting {
    protected void addProductToDB(String productName, double productPrice, int option){
        DBOperations connection = new DBOperations();
        AgricultureProduct product = new AgricultureProduct(productName, productPrice);
        CreateDBObject createDBObject = new CreateDBObject();
        connection.getCollection(option).insert(createDBObject.createProduct(product));
    }


}
