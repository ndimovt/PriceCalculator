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
            System.out.println("1 enter info 2 show info 3 exit");
            int a = inn.nextInt();
            switch (a) {
                case 1:
                    System.out.println("name");
                    inn.nextLine();
                    name = inn.nextLine();
                    System.out.println("price");
                    pr = inn.nextDouble();
                    inn.nextLine();
                    wr.addProductToDB(name, pr);
                    break;
                case 2:
                    DBReading dr = new DBReading();
                    dr.showFullInfo();
                    break;
                case 3:
                    istrue = false;
            }
        }
    }
}