package com.jonah.vttp5_paf_day04l.utils;

public class Query {
    public static final String createAccountSQL = """
            insert into BankAccount (fullname, isActive, balance) values (?,?,?);

            """;

    public static final String selectAllSQL = """
            select * from BankAccount;
            """;


    public static final String selectByBankAccountIdSQL = "select * from BankAccount where id=?;";

    public static final String deleteBankAccountByIdSQL = "update BankAccount set isActive = false where id =?;";

    public static final String updateBankBalanceByIdSQL = "update BankAccount set balance = ? where id = ?;";

    public static final String checkAccountExistsSQL = "select count(*) as cnt from BankAccount where id = ?;";
}
