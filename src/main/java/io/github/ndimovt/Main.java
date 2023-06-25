package io.github.ndimovt;

import java.util.Scanner;

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
                    DBReading dr = new DBReading();
                    dr.showInfo();
                    break;
                case 3:
                    System.out.println("YEAR");
                    int newYearCollection = inn.nextInt();
                    DBOperations dbo = new DBOperations();
                    dbo.newCollection(newYearCollection);
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