package com.stardust.currencyconverter.Utils;

import com.google.gson.Gson;
import com.stardust.currencyconverter.Entities.Currency;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class CurrencyUtils {

    public static Map<String, Double> getConversionRatesFromApi(String conversion) {
        try {
            URL url = new URL("https://open.er-api.com/v6/latest/" + conversion);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if(responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());
                while(scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                scanner.close();

                JSONParser parser = new JSONParser();
                JSONObject data = (JSONObject) parser.parse(inline);
                JSONObject rates = (JSONObject) data.get("rates");
                Map<String, Double> map = new Gson().fromJson(rates.toJSONString(), HashMap.class);
                return map;

            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Currency> generateCurrencyList() {
        Map<String, Double> dollarBase = getConversionRatesFromApi("USD");
        List<Currency> list = new ArrayList<>();
        for(String currencyName : dollarBase.keySet()) {
            Currency currency = new Currency(currencyName);
            Map<String, Double> current = new HashMap<>();
            for(String currentCurrency : dollarBase.keySet()) {
                current.put(currentCurrency, dollarBase.get(currentCurrency) / dollarBase.get(currencyName));
            }
            currency.setRates(current);
            list.add(currency);
        }
        return list;
    }
}
