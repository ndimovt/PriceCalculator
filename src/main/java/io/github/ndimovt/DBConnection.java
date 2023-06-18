package io.github.ndimovt;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static MongoClient mongoClient;
    private static DB database;
    private static DBCollection collection;
    static {
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE);
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDB("agriculture_products_and_prices");
    }

    public static DBCollection getCollection() {
        collection = database.getCollection("agriculture");
        return collection;
    }
}
