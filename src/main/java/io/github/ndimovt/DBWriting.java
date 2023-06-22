package io.github.ndimovt;

public class DBWriting {
    protected void addProductToDB(String productName, Double productPrice){
        DBConnection connection = new DBConnection();
        AgricultureProduct product = new AgricultureProduct(productName, productPrice);
        CreateDBObject createDBObject = new CreateDBObject();
        connection.getCollection().insert(createDBObject.createProduct(product));
    }


}
