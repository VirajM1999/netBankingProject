package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Account;

public class AccountRowMapper implements RowMapper<Account>{

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        long accountNumber=rs.getLong("ACCOUNT_NUMBER");
        String accountType=rs.getString("ACCOUNT_TYPE");
        String customerId=rs.getString("CUSTOMER_ID");
        double balance=rs.getDouble("BALANCE");
        double overdraftBalance=rs.getDouble("OVERDRAFT_BALANCE");
        double rateOfInterest=rs.getDouble("RATE_OF_INTEREST");
        String isApproved=rs.getString("IS_APPROVED");
        String creationDate=rs.getString("account_creation_date");
        return new Account(accountNumber, accountType, customerId, balance, overdraftBalance, rateOfInterest, isApproved,creationDate);
    }

}