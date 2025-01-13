package com.jonah.vttp5_paf_day04l.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day04l.exception.AccountInactive;
import com.jonah.vttp5_paf_day04l.exception.InsufficientBalanceException;
import com.jonah.vttp5_paf_day04l.model.BankAccount;
import com.jonah.vttp5_paf_day04l.repo.BankAccountRepo;

@Service
public class BankAccountService {
    @Autowired
    BankAccountRepo bankAccountRepo;


    public Boolean checkAccountExists(int accountId){
        return bankAccountRepo.accountExists(accountId);
    }

    public BankAccount getAccountById(int accountId){
        return bankAccountRepo.getAccountById(accountId);
    }

    public void transfer(int transfererAccountId, int transfereeAccountId, float transferAmount){
        //retrieve both accounts
        //check accounts active
        //checl transferrer has enough balance
        BankAccount accountFrom = bankAccountRepo.getAccountById(transfererAccountId);
        BankAccount accountTo = bankAccountRepo.getAccountById(transfereeAccountId);
    }

    private Boolean checkAccountActive(BankAccount account){
        if(account.getIsActive().equals(true)){
            return true;
        }
        throw new AccountInactive("Account ID " + account.getId() + "is NOT ACTIVE IN DATABASE");
    }
    
    private Boolean checkSufficientBalance(BankAccount account, float transferAmount){
        Boolean isSufficientFund = (account.getBalance() - transferAmount)>0;
        if(isSufficientFund){
            return true;
        }
        throw new InsufficientBalanceException("transferrer " + account.getFullName() + "insufficient funds!");
    }
}
