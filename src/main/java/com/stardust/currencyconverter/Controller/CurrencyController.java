package com.stardust.currencyconverter.Controller;

import com.stardust.currencyconverter.Entities.Currency;
import com.stardust.currencyconverter.Utils.CurrencyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {

    @GetMapping("/convertUSDtoJPY")
    public String calculateConversion(@RequestParam(value = "value", defaultValue = "1") String value) {
        List<Currency> list = CurrencyUtils.generateCurrencyList();
        double total = 0.0;
        for(Currency c : list) {
            if(c.getName().equals("USD")) {
                total += c.getConversionByName("JPY");
            }
        }
        return String.format("Value in YEN is " + total * Double.parseDouble(value));
    }
}
