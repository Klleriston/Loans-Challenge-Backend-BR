package com.klleriston.credChallenge.controllers;

import com.klleriston.credChallenge.domain.User;
import com.klleriston.credChallenge.dtos.AvailableLoansDTO;
import com.klleriston.credChallenge.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping("/customer-loans")
    public AvailableLoansDTO getAvailableLoans(@RequestBody User user) {
        return loanService.getAvailableLoans(user);
    }
}
