package io.github.ndimovt;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.NoSuchElementException;

public class CalculateProfit {
    private DecimalFormat df = new DecimalFormat("0.00");
    public double calculationOfProfit(int year, String agriProductName, double productQuantity) throws NoSuchElementException {
        CreateHashMap createHashMap = new CreateHashMap();
        Map<String, Double> af = createHashMap.populateMap(year);
        double value = af.get(agriProductName);
        String profit = df.format(value * productQuantity);
        return Double.parseDouble(profit);
        }
    }
