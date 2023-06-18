package io.github.ndimovt;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class CreateDBObject {
    public DBObject createProduct(AgricultureProduct agricultureProduct){
        return new BasicDBObject("Product",agricultureProduct.getProductName()).append("Price per Ton",agricultureProduct.getProductPrice());
    }


}
