package org.example.bankingapplication.mapper;

import org.example.bankingapplication.Dto.AccountDto;
import org.example.bankingapplication.entity.*;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance(),
                accountDto.getAddress()
        );

        return  account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance(),
                account.getAddress()
        );
        return  accountDto;
    }


}
