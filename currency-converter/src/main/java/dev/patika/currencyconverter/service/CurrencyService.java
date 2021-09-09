package dev.patika.currencyconverter.service;

import dev.patika.currencyconverter.model.Currency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    @Value("${tlUsd.exchangeRate}")
    private double convertRate;

    public Currency convertTlToUsd(Integer amount) {
        return new Currency((amount*(100/convertRate)),"USD");
    }

    public Currency convertUsdToTl(Integer amount){
        return new Currency((amount*(convertRate)),"TL");
    }
}