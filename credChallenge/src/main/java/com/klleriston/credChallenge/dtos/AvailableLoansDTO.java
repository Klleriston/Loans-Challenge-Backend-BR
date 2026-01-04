package com.klleriston.credChallenge.dtos;

import java.util.List;

public record AvailableLoansDTO(
        String userName,
        List<LoanDTO> availableLoans
) {}
