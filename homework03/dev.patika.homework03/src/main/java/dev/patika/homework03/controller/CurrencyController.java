package dev.patika.homework03.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Currency;

@Controller
@RequestMapping("api/getCurrency")
@RequiredArgsConstructor
public class CurrencyController {
    private final RestTemplate restTemplate;



    @GetMapping("/convert100TltoUsd")
    public Currency convert100TltoUsd(){
        Currency currency = restTemplate.getForObject("http://localhost:8081/api/convertTlToUsd/100", Currency.class);
        return currency;
    }

    @GetMapping("/convert100UsdtoTl")
    public Currency convert100UsdtoTl(){
        Currency currency = restTemplate.getForObject("http://localhost:8081/api/convertUsdtoTl/100", Currency.class);
        return currency;
    }
}
