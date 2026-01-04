package com.klleriston.credChallenge.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User{
    private String name;
    private String cpf;
    private int age;
    private BigDecimal income;
    private String location;
}
