package com.klleriston.credChallenge.services.impl;

import com.klleriston.credChallenge.dtos.AvailableLoansDTO;
import com.klleriston.credChallenge.dtos.LoanDTO;
import com.klleriston.credChallenge.domain.User;
import com.klleriston.credChallenge.services.LoanService;
import com.klleriston.credChallenge.domain.LoanRulesProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRulesProvider loanRulesProvider;

    @Override
    public AvailableLoansDTO getAvailableLoans(User user) {

        List<LoanDTO> loans =
                loanRulesProvider.getLoanRules().stream()
                        .filter(rule -> rule.matches(user))
                        .flatMap(rule -> rule.allowedLoans().stream())
                        .distinct()
                        .map(loanType -> new LoanDTO(
                                loanType.name(),
                                loanType.getInterest_rate()
                        ))
                        .toList();

        return new AvailableLoansDTO(user.getName(), loans);
    }
}
