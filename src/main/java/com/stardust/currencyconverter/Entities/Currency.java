package com.stardust.currencyconverter.Entities;

import jakarta.persistence.Entity;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Currency {
    private final String name;
    private final Map<String, Double> rates;

    public Currency(String cName) {
        name = cName;
        rates = new HashMap<>();
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

    public static Map<String, Double> getConversionRatesFromApi() throws Exception {
        throw new Exception("Not yet implemented");
    }

    @Override
    public String toString() {
        System.out.println(name + ":");
        System.out.println("{");
        for(String name : rates.keySet()) {
            System.out.println(" " + name + " " + rates.get(name));
        }
        System.out.println("}");
        return null;
    }
}
