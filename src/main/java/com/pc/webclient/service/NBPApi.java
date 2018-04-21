package com.pc.webclient.service;

import com.pc.webclient.model.Currency;
import com.pc.webclient.model.CurrencyRequest;

import reactor.core.publisher.Mono;

public interface NBPApi {

    Mono<Currency> getBetween(CurrencyRequest currencyRequest);

}
