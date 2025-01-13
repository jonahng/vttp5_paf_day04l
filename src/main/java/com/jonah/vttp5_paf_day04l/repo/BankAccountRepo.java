package com.jonah.vttp5_paf_day04l.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jonah.vttp5_paf_day04l.model.BankAccount;
import com.jonah.vttp5_paf_day04l.utils.Query;

@Repository
public class BankAccountRepo {
    @Autowired
    JdbcTemplate template;


    public Boolean accountExists(int accountId){
        try {
        BankAccount bankAccount = template.queryForObject(Query.selectByBankAccountIdSQL,
        BeanPropertyRowMapper.newInstance(BankAccount.class), accountId);
        //use could also select count where id=accountId.
        return true;
        //returns data access exception if cannot find record
            
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
       
    }

    
}
