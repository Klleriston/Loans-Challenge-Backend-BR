package com.klleriston.credChallenge.domain;

import java.util.Set;
import java.util.function.Predicate;

public record LoanRule(Predicate<User> condition, Set<LoanType> allowedLoans) {

    public LoanRule(Predicate<User> condition, Set<LoanType> allowedLoans) {
        this.condition = condition;
        this.allowedLoans = Set.copyOf(allowedLoans);
    }

    public boolean matches(User user) {
        return condition.test(user);
    }
}


