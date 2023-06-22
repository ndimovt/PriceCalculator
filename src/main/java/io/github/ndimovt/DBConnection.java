package io.github.ndimovt;

import com.mongodb.*;
import com.mongodb.client.model.CreateCollectionOptions;

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
        database = mongoClient.getDB("agriculture_products_prices_2022");
    }

    public static DBCollection getCollection() {
        collection = database.getCollection("2022");
        return collection;
    }

}
