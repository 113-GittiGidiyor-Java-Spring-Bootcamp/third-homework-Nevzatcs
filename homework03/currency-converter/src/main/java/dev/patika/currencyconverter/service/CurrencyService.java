package dev.patika.currencyconverter.service;


import dev.patika.currencyconverter.dao.CurrencyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrency {


    CurrencyDAO currencyDAO;
    @Autowired
    public CurrencyService(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }
    public Double exchangeMoney(int id,double money){
        double result=money*(currencyDAO.findById(id).get().getFixedRate());
        return result;
    }



}
