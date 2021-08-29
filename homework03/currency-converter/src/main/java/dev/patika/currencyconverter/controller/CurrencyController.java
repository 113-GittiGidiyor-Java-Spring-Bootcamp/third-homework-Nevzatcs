package dev.patika.currencyconverter.controller;

import dev.patika.currencyconverter.service.ICurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class CurrencyController {

    ICurrency currency;

    @Autowired
    public CurrencyController(ICurrency currency) {
        this.currency = currency;
    }
    @PostMapping("/exchangeMoney")
    public Double exchangeMoney(@PathVariable int id,@PathVariable double money){
        return currency.exchangeMoney(id,money);
    }
}
