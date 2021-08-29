package dev.patika.currencyconverter.dao;

import dev.patika.currencyconverter.model.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyDAO extends CrudRepository<Currency,Integer> {
}
