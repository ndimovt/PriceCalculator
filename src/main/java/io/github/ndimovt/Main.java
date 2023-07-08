package io.github.ndimovt;

import java.util.Scanner;
import MongoUtilityPackage.DBConnectionAndCreateCollection;

public class Main {
    public static void main(String[] args) {
        ReadShowCalculate readShowCalculate = new ReadShowCalculate();
        Scanner inn = new Scanner(System.in);
        boolean istrue = true;
        String name;
        double pr;
        while (istrue) {
            System.out.println("1) Enter info 2) Show full info 3) Create new year 4) Calculate Price 5) Exit");
            int a = inn.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Enter Year:");
                    int year = inn.nextInt();
                    System.out.println("Enter product name:");
                    do {
                        name = inn.nextLine();
                    }while(name.isEmpty());
                    System.out.println("Enter product price:");
                    pr = inn.nextDouble();
                    DBWriting wr = new DBWriting();
                    wr.addProductToDB(name, pr, year);
                    break;
                case 2:
                    System.out.println("Enter year to get information:");
                    int infoYear = inn.nextInt();
                    readShowCalculate.showInfo(infoYear);
                    break;
                case 3:
                    System.out.println("Enter year to create a new collection:");
                    int newYearCollection = inn.nextInt();
                    DBConnectionAndCreateCollection.newCollection(newYearCollection);
                    System.out.println("New table for year "+newYearCollection+" created. You can now insert records in it.");
                    break;
                case 4:
                    System.out.println("Enter year to get information:");
                    int av = inn.nextInt();
                    System.out.println("Enter product name:");
                    inn.nextLine();
                    String prod = inn.nextLine();
                    System.out.println("Enter quantity in tons: ");
                    double quantity = inn.nextDouble();
                    try {
                        System.out.println(readShowCalculate.calculateProfit(av, prod, quantity) + "$");
                    }catch (NullPointerException npe){
                        System.out.println("Enter name of the product with capital letter! Ex: Mango!");
                    }
                    break;
                case 5:
                    istrue = false;
                    break;
                default:
                    break;
            }
        }
    }
}