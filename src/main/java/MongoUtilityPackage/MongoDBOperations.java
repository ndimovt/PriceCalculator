package MongoUtilityPackage;

import com.mongodb.*;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDBOperations {
    private MongoClient mongoClient;
    private DB database;
    private  DBCollection collection;
    private final String DATABASENAME = "agriculture_products_prices_2022";

    {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDB(DATABASENAME);
    }

    public DBCollection getCollection(int choice) {
        collection = database.getCollection(String.valueOf(choice));
        return collection;
    }
    public DBCollection newCollection(int year) {
        String agrycultureYear = Integer.toString(year);
        return database.createCollection(agrycultureYear, new BasicDBObject());
    }

    public String getDATABASENAME() {
        return DATABASENAME;
    }
}
