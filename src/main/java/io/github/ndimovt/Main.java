package io.github.ndimovt;

public class Main {
    public static void main(String[] args) {
        AddInfoToDB addInfoToDB = new AddInfoToDB();
        //addInfoToDB.addProductToDB("Rice",6.32);
        DBReading read = new DBReading();
        read.showFullInfo();

    }
}