package com.jonah.vttp5_paf_day04l.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonah.vttp5_paf_day04l.model.BankAccount;
import com.jonah.vttp5_paf_day04l.service.BankAccountService;

@RestController
@RequestMapping("/api/bankaccounts")
public class BankAccountRestController {
    @Autowired
    BankAccountService bankAccountService;


    @GetMapping("/exists/{account-id}")
    public ResponseEntity<Boolean> checkAccountExists(@PathVariable("account-id") Integer accountId){
        Boolean isAccountExists = bankAccountService.checkAccountExists(accountId);
        return ResponseEntity.ok().body(isAccountExists);
    }


    @GetMapping("/{account-id}")
    public ResponseEntity<BankAccount> getById(@PathVariable("account-id") Integer accountId){
        BankAccount account = bankAccountService.getAccountById(accountId);
        return ResponseEntity.ok().body(account);
    }

    @PostMapping("/transfer/from/{account-from}/to/{account-to}/amount/{transfer-amount}")
    public ResponseEntity<Boolean> transferFund(@PathVariable("account-from") Integer accountFromId,
    @PathVariable("account-to") Integer accountToId,@PathVariable("transfer-amount") float amount){
        Boolean bTransferred = bankAccountService.transfer(accountFromId,accountToId, amount);
        return ResponseEntity.ok().body(bTransferred);
    }
    
}
