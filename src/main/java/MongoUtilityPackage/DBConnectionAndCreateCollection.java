package MongoUtilityPackage;

import com.mongodb.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnectionAndCreateCollection {
    private static MongoClient mongoClient;
    private static DB database;
    private  static DBCollection collection;
    private static final String DATABASENAME = "agriculture_products_prices_2022";

    static {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDB(DATABASENAME);
    }

    public static DBCollection getCollection(int choice) {
        collection = database.getCollection(String.valueOf(choice));
        return collection;
    }
    public static DBCollection newCollection(int year) {
        String agrycultureYear = Integer.toString(year);
        return database.createCollection(agrycultureYear, new BasicDBObject());
    }
}
