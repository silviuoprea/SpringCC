package com.stardust.currencyconverter;

import com.stardust.currencyconverter.Entities.Currency;
import com.stardust.currencyconverter.Utils.CurrencyUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CurrencyConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
		System.out.println("Reached here");
		List<Currency> list = CurrencyUtils.generateCurrencyList();
		for(Currency c : list) {
			System.out.println(c);
		}
	}

}
