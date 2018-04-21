package com.pc.webclient.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Rate {

    @JsonProperty("effectiveDate")
    private String effectiveDate;
    @JsonProperty("mid")
    private BigDecimal mid;
}
