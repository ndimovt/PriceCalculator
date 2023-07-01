package io.github.ndimovt;

import java.util.Scanner;
import MongoUtilityPackage.MongoDBOperations;

public class Main {
    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        boolean istrue = true;
        DBWriting wr = new DBWriting();
        String name;
        double pr;
        while (istrue) {
            System.out.println("1 enter info 2 show info 3 create new year 4 exit");
            int a = inn.nextInt();
            switch (a) {
                case 1:
                    System.out.println("YEAR");
                    int year = inn.nextInt();
                    System.out.println("name");
                    do {
                        name = inn.nextLine();
                    }while(name.isEmpty());
                    System.out.println("price");
                    pr = inn.nextDouble();
                    wr.addProductToDB(name, pr, year);
                    break;
                case 2:
                    MongoDBOperations mdbOperations = new MongoDBOperations();
                    System.out.println("Enter database name");
                    inn.nextLine();
                    String dbName = inn.nextLine();
                    if(dbName.equals(mdbOperations.getDATABASENAME())){
                        DBReading dr = new DBReading();
                        dr.showInfo();
                        break;
                    }else {
                        System.out.println("Database does not exist");
                        break;
                    }
                case 3:
                    System.out.println("YEAR");
                    int newYearCollection = inn.nextInt();
                    MongoDBOperations mongoDBOperationsdbo = new MongoDBOperations();
                    mongoDBOperationsdbo.newCollection(newYearCollection);
                    System.out.println("New table for year "+newYearCollection+" created. You can now insert records in it.");
                    break;
                case 4:
                    istrue = false;
                    break;
                default:
                    break;
            }
        }
    }
}