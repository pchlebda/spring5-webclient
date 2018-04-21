package com.pc.webclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pc.webclient.model.Currency;
import com.pc.webclient.model.CurrencyRequest;

import reactor.core.publisher.Mono;

@Service
public class NBPApiService implements NBPApi {

    private static String NBP_API_URL = "http://api.nbp.pl/api/exchangerates/rates/a/";
    private static String NBP_API_CURRENCY_FORMAT = "%s/%s/%s";

    private final WebClient webClient;

    public NBPApiService() {
        this.webClient = WebClient.create(NBP_API_URL);
    }

    @Override
    public Mono<Currency> getBetween(CurrencyRequest currencyRequest) {
        String uri = String.format(NBP_API_CURRENCY_FORMAT, currencyRequest.getCurrencyCode(),
                currencyRequest.getBegin(), currencyRequest.getEnd());
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Currency.class);
    }
}
