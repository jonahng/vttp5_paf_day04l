package com.jonah.vttp5_paf_day04l.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jonah.vttp5_paf_day04l.exception.AccountNotFoundException;
import com.jonah.vttp5_paf_day04l.model.BankAccount;
import com.jonah.vttp5_paf_day04l.utils.Query;

@Repository
public class BankAccountRepo {
    @Autowired
    JdbcTemplate template;


    public Boolean accountExists(int accountId){
        try {
            System.out.println("trying to check for account:");
        BankAccount bankAccount = template.queryForObject(Query.selectByBankAccountIdSQL,
        BeanPropertyRowMapper.newInstance(BankAccount.class), accountId);
        System.out.println("THE ACCOUNT BALANCE IS" + bankAccount.getBalance());
        //use could also select count where id=accountId.
        return true;
        //returns data access exception if cannot find record
            
        } catch (Exception e) {
            //throw new AccountNotFoundException("THE ACCOUNT YOU ARE LOOKING FOR AINT HERE!!");
            // TODO: handle exception
            return false;
        }
       
    }


    public BankAccount getAccountById(int accountId){
        try {
            BankAccount account = template.queryForObject(Query.selectByBankAccountIdSQL,
            BeanPropertyRowMapper.newInstance(BankAccount.class), accountId);
            return account;
        } catch (Exception e) {
            // TODO: handle exception
            throw new DataAccessException("ACCOUNT WITH ID" + accountId + "IS NOT IN DATABASE") {
            };
        }
    }

    public Boolean updateAccountById(BankAccount accountToUpdate){
        //this is to get the account??NOT SURE WHAT THIS DOES, THIS TAKES IN THE NEW UPDATED ACCOUNT AND WRITES IT TO DATABASE
        int accountUpdated = template.update(Query.updateBankBalanceByIdSQL, accountToUpdate.getBalance(),accountToUpdate.getId());
        if (accountUpdated >0){
            return true;
        }
        return false;
    }





    

    
}
