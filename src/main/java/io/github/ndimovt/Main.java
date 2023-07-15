package io.github.ndimovt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DisplayInfo displayInfo = new DisplayInfo();
        Scanner inn = new Scanner(System.in);
        boolean istrue = true;
        String name;
        double pr;
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
                    }while(name.isEmpty());
                    System.out.println("Enter product price:");
                    pr = inn.nextDouble();
                    DBWriting wr = new DBWriting();
                    wr.addProductToDB(year,name,pr);
                    break;
                case 2:
                    System.out.println("Enter year to get information:");
                    int infoYear = inn.nextInt();
                    displayInfo.displayInfoForParticularYear(infoYear);
                    break;
                case 3:
                    System.out.println("Enter year to get information:");
                    int av = inn.nextInt();
                    System.out.println("Enter product name:");
                    inn.nextLine();
                    String prod = inn.nextLine();
                    System.out.println("Enter quantity in tons: ");
                    double quantity = inn.nextDouble();
                    try {
                        CalculateProfit calculateProfit = new CalculateProfit();
                        System.out.println(calculateProfit.calculateProfit(av, prod, quantity) + "$");
                    }catch (NullPointerException npe){
                        System.out.println("Enter name of the product with capital letter! Ex: Mango!");
                    }
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