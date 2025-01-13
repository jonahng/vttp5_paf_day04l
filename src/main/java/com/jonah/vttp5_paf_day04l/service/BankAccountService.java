package com.jonah.vttp5_paf_day04l.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day04l.repo.BankAccountRepo;

@Service
public class BankAccountService {
    @Autowired
    BankAccountRepo bankAccountRepo;


    public Boolean checkAccountExists(int accountId){
        return bankAccountRepo.accountExists(accountId);
    }
    
}
