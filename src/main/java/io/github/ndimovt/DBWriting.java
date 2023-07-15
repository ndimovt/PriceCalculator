package io.github.ndimovt;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import io.github.ndimovt.mongoutilitypackage.DBConnection;

import java.util.regex.Pattern;

public class DBWriting {
    public void addProductToDB(int year,String productName, double productPrice){
        BasicDBObject yearQuerry = new BasicDBObject("year",year);
        BasicDBObject nameQuerry = new BasicDBObject("product_name", Pattern.compile("^"+productName+"$",Pattern.CASE_INSENSITIVE));
        DBCursor yearCursor = DBConnection.getCollection().find(yearQuerry);
        DBCursor nameCursor = DBConnection.getCollection().find(nameQuerry);
        if(!yearCursor.hasNext() && !nameCursor.hasNext()){
            AgricultureProduct agricultureProduct = new AgricultureProduct(year,productName,productPrice);
            DBConnection.getCollection().insert(createProduct(agricultureProduct));
            System.out.println("Record added successfully to database");
        }else{
            System.out.println("Product "+productName+" already exists for "+year);
        }
    }
    private DBObject createProduct(AgricultureProduct agricultureProduct){
        return new BasicDBObject("year",agricultureProduct.getYear()).append("product_name",agricultureProduct.getProductName()).
                append("product_price",agricultureProduct.getProductPrice());
    }
}
