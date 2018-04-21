package com.pc.webclient.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Builder
public class CurrencyRequest {

    private String begin;
    private String end;
    private String currencyCode;
}
