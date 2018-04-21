package com.pc.webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pc.webclient.model.Currency;
import com.pc.webclient.model.CurrencyRequest;
import com.pc.webclient.service.NBPApi;

import reactor.core.publisher.Mono;

@RestController
public class NBPController {

    private NBPApi nbpApi;

    @Autowired
    public NBPController(NBPApi nbpApi) {
        this.nbpApi = nbpApi;
    }

    @RequestMapping(value = "/nbp")
    public Mono<Currency> getCurrency(@RequestParam("currency") String currency, @RequestParam("begin") String begin,
            @RequestParam("end") String end) {
        CurrencyRequest currencyRequest = CurrencyRequest.builder()
                .currencyCode(currency)
                .begin(begin)
                .end(end)
                .build();
        return nbpApi.getBetween(currencyRequest);
    }
}
