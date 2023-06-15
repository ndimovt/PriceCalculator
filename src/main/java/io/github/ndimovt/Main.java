package io.github.ndimovt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner inn = new Scanner(System.in);
            System.out.println("Enter year to get prices");
            String year = inn.nextLine();
            //System.out.println("Enter agriculture name");
            //String agriculture = inn.nextLine();
            //new DBReading().getSpecificAgricultureInfo(year, agriculture);
            new DBReading().getEntireAgricultureProductInfo(year);
        } catch (NullPointerException npe) {
            System.out.println("No information for that year");
            npe.printStackTrace();
        }
    }
}