package com.klleriston.credChallenge.services;

import com.klleriston.credChallenge.dtos.AvailableLoansDTO;
import com.klleriston.credChallenge.domain.User;

public interface LoanService {
    AvailableLoansDTO getAvailableLoans(User user);
}
