package com.klleriston.credChallenge.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Component
public class LoanRulesProvider {

    private static final BigDecimal INCOME_3000 = new BigDecimal("3000");
    private static final BigDecimal INCOME_5000 = new BigDecimal("5000");

    private final List<LoanRule> loanRules = List.of(
            new LoanRule(
                    user -> user.getIncome().compareTo(INCOME_3000) <= 0,
                    Set.of(LoanType.PERSONAL, LoanType.GUARANTEED)
            ),
            new LoanRule(
                    user ->
                            user.getIncome().compareTo(INCOME_3000) >= 0 &&
                                    user.getIncome().compareTo(INCOME_5000) <= 0 &&
                                    "SP".equalsIgnoreCase(user.getLocation()) &&
                                    user.getAge() < 30,
                    Set.of(LoanType.PERSONAL, LoanType.GUARANTEED)
            ),
            new LoanRule(
                    user -> user.getIncome().compareTo(INCOME_5000) >= 0,
                    Set.of(LoanType.CONSIGNMENT)
            )
    );

    public List<LoanRule> getLoanRules() {
        return loanRules;
    }
}
