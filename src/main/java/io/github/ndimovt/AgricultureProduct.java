package io.github.ndimovt;

public class AgricultureProduct {
    private String productName;
    private double productPrice;

    public AgricultureProduct(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }
}

