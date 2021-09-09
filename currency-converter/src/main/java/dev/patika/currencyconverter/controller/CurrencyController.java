package dev.patika.currencyconverter.controller;


import dev.patika.currencyconverter.model.Currency;
import dev.patika.currencyconverter.service.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;


    @GetMapping("/tlToUsd/{amount}")
    public Currency convertTlToUsd(@PathVariable Integer amount){
        return currencyService.convertTlToUsd(amount);
    }

    @GetMapping("/usdToTl/{amount}")
    public Currency convertUsdToTl(@PathVariable Integer amount){
        return currencyService.convertUsdToTl(amount);
    }
}