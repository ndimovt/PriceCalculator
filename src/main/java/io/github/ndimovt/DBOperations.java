package io.github.ndimovt;

import com.mongodb.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DBOperations {
    private static MongoClient mongoClient;
    private static DB database;
    private static DBCollection collection;
    static {
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE);
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDB("agriculture_products_prices_2022");
    }

    public static DBCollection getCollection(int choice) {
        collection = database.getCollection(String.valueOf(choice));
        return collection;
    }
    public static DBCollection newCollection(int year){
        String agrycultureYear = Integer.toString(year);
        return database.createCollection(agrycultureYear, new BasicDBObject());
    }

}
