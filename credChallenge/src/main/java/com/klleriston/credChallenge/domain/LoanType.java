package com.klleriston.credChallenge.domain;

import lombok.Getter;

@Getter
public enum LoanType {
    PERSONAL(4),
    CONSIGNMENT(2),
    GUARANTEED(3);

    private final int interest_rate;

    LoanType(int interest_rate) {
        this.interest_rate = interest_rate;
    }
}
