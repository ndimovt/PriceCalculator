package io.github.ndimovt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        boolean istrue = true;
        String name;
        while (istrue) {
            System.out.println("1) Enter info 2) Show full info 3) Calculate Price 4) Exit");
            int a = inn.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Enter Year:");
                    int year = inn.nextInt();
                    System.out.println("Enter product name:");
                    do {
                        name = inn.nextLine();
                    } while (name.isEmpty());
                    System.out.println("Enter product price:");
                    double productPrice = inn.nextDouble();
                    insertRecordInDB(year, name, productPrice);
                    break;
                case 2:
                    System.out.println("Enter year to get information:");
                    int infoYear = inn.nextInt();
                    showInfo(infoYear);
                    break;
                case 3:
                    System.out.println("Enter year to get information:");
                    int productYear = inn.nextInt();
                    System.out.println("Enter product name:");
                    inn.nextLine();
                    String prod = inn.nextLine();
                    System.out.println("Enter quantity in tons: ");
                    double quantity = inn.nextDouble();
                    System.out.println(profit(productYear, prod, quantity) + "$");
                    break;
                case 4:
                    istrue = false;
                    break;
                default:
                    break;
            }
        }
    }

    private static double profit(int year, String productName, double quantity) {
        try {
            CalculateProfit calculateProfit = new CalculateProfit();
            return calculateProfit.calculationOfProfit(year, productName, quantity);
        } catch (NullPointerException npe) {
            System.out.println("This product does not exist!");
        }
        return 0.00;
    }

    private static void showInfo(int year) {
        DisplayInfo di = new DisplayInfo();
        di.displayInfoForParticularYear(year);
    }
    private static void insertRecordInDB(int year, String name, double price) {
            DBWriting dbwr = new DBWriting();
            dbwr.addProductToDB(year,name,price);
    }
}