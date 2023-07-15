package io.github.ndimovt.mongoutilitypackage;

import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClientURI;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static MongoClient mongoClient;
    private static DB database;
    private static DBCollection collection;
    private static final String DATABASENAME = "agriculture_products_prices";
    private static final String COLLECTIONNAME = "products_and_prices";
    private static final String DBADRESS = "mongodb://localhost:27017";

    static {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        mongoClient = new MongoClient(new MongoClientURI(DBADRESS));
        database = mongoClient.getDB(DATABASENAME);
        collection = database.getCollection(COLLECTIONNAME);
    }
    public static DBCollection getCollection() {
        return collection;
    }

}
