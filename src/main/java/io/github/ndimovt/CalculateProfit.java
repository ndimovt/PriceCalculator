package io.github.ndimovt;

import java.text.DecimalFormat;
import java.util.Map;

public class CalculateProfit {
    private DecimalFormat df = new DecimalFormat("0.00");
    public double calculationOfProfit(int year, String agriProductName, double productQuantity) throws NullPointerException{
        CreateHashMap createHashMap = new CreateHashMap();
        Map<String, Double> af = createHashMap.populateMap(year);
        double value = af.get(agriProductName);
        String profit = df.format(value*productQuantity);
        return Double.parseDouble(profit);
    }
}
