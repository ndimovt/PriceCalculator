package io.github.ndimovt;

public class AgricultureProduct {
    private int year;
    private String productName;
    private double productPrice;

    public AgricultureProduct(int year,String productName, double productPrice) {
        this.year = year;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getYear() {
        return year;
    }
}

