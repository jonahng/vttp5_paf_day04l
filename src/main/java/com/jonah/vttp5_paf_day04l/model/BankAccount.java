package com.jonah.vttp5_paf_day04l.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    
    private int id;
    private String fullName;
    private Boolean isActive;
    private Float balance;

}
