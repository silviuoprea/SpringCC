package com.stardust.currencyconverter.Entities;
import java.util.*;

public class Currency {
    private final String name;
    private Map<String, Double> rates;

    public Currency(String cName) {
        name = cName;
        rates = new HashMap<>();
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public Double getConversionByName(String conversion) {
        return rates.get(conversion);
    }

    public String getName() {
        return name;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void addRate(String name, Double value) {
        rates.put(name, value);
    }

    @Override
    public String toString() {
        System.out.println(name + ":");
        System.out.println("{");
        for(String name : rates.keySet()) {
            System.out.println(" " + name + " " + rates.get(name));
        }
        System.out.println("}");
        return "";
    }
}
